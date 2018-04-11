package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.Actor;
import com.dbms.project.moovi.data.entity.AdRecruiter;
import com.dbms.project.moovi.data.entity.Fan;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dbms.project.moovi.data.repository.ActorRepository;
import com.dbms.project.moovi.data.repository.AdRecruiterRepository;
import com.dbms.project.moovi.data.repository.FanRepository;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

@RestController
public class ActorService extends Utils{

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private AdRecruiterRepository adRecruiterRepository;

    @Autowired
    private FanRepository fanRepository;

    @PostMapping("/api/actor")
    public Actor createActor(@RequestBody Actor actor) {
        return actorRepository.save(actor);
    }

    @GetMapping("/api/actor")
    public List<Actor> findAllActors(){
        return (List<Actor>) actorRepository.findAll();
    }

    @GetMapping("/api/actor/{actorId}")
    public Actor findActorById(@PathVariable(name = "actorId") long actorId) {
        return (Actor) actorRepository.findActorById(actorId);
    }

    @PostMapping("api/recruit/actor/{actorId}/adrecruiter/{username}")
    public void AdRecruiterRecruitsActor(
            @PathVariable("username") String username,
            @PathVariable("actorId") long actorId){

        Actor actor = (Actor) actorRepository.findActorById(actorId);
        AdRecruiter adRecruiter = (AdRecruiter) adRecruiterRepository.findAdRecruiterByUsername(username);
        actor.actorRecruitedBy(adRecruiter);
        actorRepository.save(actor);
    }

    @PostMapping("api/follow/actor/{actorId}/fan/{username}")
    public void FanFollowsActor(
            @PathVariable("username") String username,
            @PathVariable("actorId") long actorId){

        Actor actor = (Actor) actorRepository.findActorById(actorId);
        Fan fan = (Fan) fanRepository.findFanByUsername(username);
        actor.followedBy(fan);
        actorRepository.save(actor);
    }

    @GetMapping("api/follow/actor/{actorId}/fanfollowing")
    public List<Fan> listOfFansFollowing(
            @PathVariable("actorId") long actorId) {

        Actor actor = (Actor) actorRepository.findActorById(actorId);
        return actor.getFansFollowingActor();
    }

    @GetMapping("/api/search/actor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public JSONArray getActor(
            @RequestParam(value = "actorName", required = false) String actorName){
                String searchUrlString;
        if(actorName != null)
            searchUrlString = "https://api.themoviedb.org/3/search/person?api_key="+apiKey+"&query="+actorName.replace(" ","+");
        else
            searchUrlString = "https://api.themoviedb.org/3/person/popular?api_key="+apiKey;
        JSONObject jsonObject;
        JSONArray jsonArray = new JSONArray();

        try {
            URL url = new URL(searchUrlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if(responseCode != 200)
                throw new RuntimeException("HttpResponseCode from Actor Service: " + responseCode);
            else{
                StringBuilder inline = new StringBuilder();
                Scanner sc = new Scanner(url.openStream());
                while(sc.hasNext())
                {
                    inline.append(sc.nextLine());
                }
                sc.close();
                JSONParser parse = new JSONParser();
                JSONObject jsonObject1 = (JSONObject) parse.parse(inline.toString());
                JSONArray results = (JSONArray) jsonObject1.get("results");
                long[] idArray = new long[results.size()];
                for(int i=0;i<results.size();i++)
                {
                    JSONObject jsonObject2 = (JSONObject)results.get(i);
                    idArray[i] = (long) jsonObject2.get("id");
                }
                for(long actorId: idArray){
                    String getActor = "https://api.themoviedb.org/3/person/"+actorId+"?api_key="+apiKey+"&language=en-US";
                    URL url1 = new URL(getActor);
                    HttpURLConnection connection1 = (HttpURLConnection) url.openConnection();
                    connection1.setRequestMethod("GET");
                    connection1.connect();
                    inline = new StringBuilder();
                    Scanner scanner = new Scanner(url1.openStream());
                    while(scanner.hasNext())
                    {
                        inline.append(scanner.nextLine());
                    }
                    scanner.close();
                    jsonObject = (JSONObject) parse.parse(inline.toString());
                    JSONObject object = new JSONObject();
                    double l=0;
                    if(jsonObject.get("birthday") == null)
                        object.put("dob","-");
                    else
                        object.put("dob", jsonObject.get("birthday"));
                    if(jsonObject.get("deathday") == null)
                        object.put("dod","-");
                    else
                        object.put("dod", jsonObject.get("deathday"));
                    if(jsonObject.get("imdb_id") == null)
                        object.put("imdbId","-");
                    else
                        object.put("imdbId", jsonObject.get("imdb_id"));
                    if(jsonObject.get("biography") == null)
                        object.put("biography","-");
                    else
                        object.put("biography", jsonObject.get("biography"));
                    if(jsonObject.get("popularity") == null)
                        object.put("actorPopularity","-");
                    else
                        object.put("actorPopularity", jsonObject.get("popularity"));

                    object.put("actorName",jsonObject.get("name"));
                    object.put("actorId", jsonObject.get("id"));
                    jsonArray.add(object);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    @GetMapping("/api/recruit/actor/{actorId}/recruitedby")
    public List<AdRecruiter> getListOfAdrecruiters(
            @PathVariable("actorId") long actorId){
        Actor actor = (Actor) actorRepository.findActorById(actorId);
        return actor.getRecruitedBy();
    }
}
