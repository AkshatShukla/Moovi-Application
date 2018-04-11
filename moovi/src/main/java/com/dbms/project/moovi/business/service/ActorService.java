package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.Actor;
import com.dbms.project.moovi.data.entity.AdRecruiter;
import com.dbms.project.moovi.data.entity.Fan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dbms.project.moovi.data.repository.ActorRepository;
import com.dbms.project.moovi.data.repository.AdRecruiterRepository;
import com.dbms.project.moovi.data.repository.FanRepository;

import java.util.List;

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
}
