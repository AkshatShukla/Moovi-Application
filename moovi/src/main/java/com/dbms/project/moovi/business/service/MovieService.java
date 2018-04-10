package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.Fan;
import com.dbms.project.moovi.data.entity.Movie;
import com.dbms.project.moovi.data.repository.FanRepository;
import com.dbms.project.moovi.data.repository.MovieRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

@RestController
public class MovieService extends APICredentials {

    @Autowired
    MovieRepository movieRepository;
    
    @Autowired
    FanRepository fanRepository;

    @RequestMapping(value = "/api/movie/{movieName}", method = RequestMethod.GET)
    public JSONArray displayMovies(@PathVariable("movieName") String movieName) {
        String searchUrlString = "https://api.themoviedb.org/3/search/movie?api_key="+apiKey+"&query="+movieName;
        JSONObject jobj1;
        JSONArray jsonArray = new JSONArray();
        try {
            URL searchMovieUrl = new URL(searchUrlString);
            HttpURLConnection conn = (HttpURLConnection)searchMovieUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode != 200)
                throw new RuntimeException("HttpResponseCode: " +responseCode);
            else
            {
                StringBuilder inline = new StringBuilder();
                Scanner sc = new Scanner(searchMovieUrl.openStream());
                while(sc.hasNext())
                {
                    inline.append(sc.nextLine());
                }
                sc.close();
                JSONParser parse = new JSONParser();
                JSONObject jobj = (JSONObject)parse.parse(inline.toString());
                JSONArray jsonarr_1 = (JSONArray) jobj.get("results");

                long[] idArray = new long[jsonarr_1.size()];

                //Get data for Results array
                for(int i=0;i<jsonarr_1.size();i++)
                {
                    //Store the JSON objects in an array
                    //Get the index of the JSON object and print the values as per the index
                    JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
                    //Store the JSON object in JSON array as objects (For level 2 array element i.e Address Components)
                    //JSONArray jsonarr_2 = (JSONArray) jsonobj_1.get("address_components");
                    //System.out.println("Elements under results array");

                    idArray[i] = (long) jsonobj_1.get("id");
                    System.out.println("\nMovie id: " +jsonobj_1.get("id"));
                    System.out.println("Movie name: " +jsonobj_1.get("original_title"));
                    System.out.println("IMDb Rating: "+jsonobj_1.get("vote_average"));
                    //Get data for the Address Components array
//                    System.out.println("Elements under address_components array");
//                    System.out.println("The long names, short names and types are:");
//                    for(int j=0;j<jsonarr_2.size();j++)
//                    {
//                        //Same just store the JSON objects in an array
//                        //Get the index of the JSON objects and print the values as per the index
//                        JSONObject jsonobj_2 = (JSONObject) jsonarr_2.get(j);
//                        //Store the data as String objects
//                        String str_data1 = (String) jsonobj_2.get("long_name");
//                        System.out.println(str_data1);
//                        String str_data2 = (String) jsonobj_2.get("short_name");
//                        System.out.println(str_data2);
//                        System.out.println(jsonobj_2.get("types"));
//                        System.out.println("\n");
//                    }
                }

                Movie movie = new Movie();
                for (long movieId:idArray) {
                    String findMovieUrlString = "https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey+"&language=en-US";

                    URL findMovieUrl = new URL(findMovieUrlString);
                    HttpURLConnection conn1 = (HttpURLConnection)findMovieUrl.openConnection();
                    conn1.setRequestMethod("GET");
                    conn1.connect();

                    inline = new StringBuilder();
                    Scanner scanner = new Scanner(findMovieUrl.openStream());
                    while(scanner.hasNext())
                    {
                        inline.append(scanner.nextLine());
                    }
                    System.out.println("\nJSON data in string format");
                    System.out.println(inline);
                    scanner.close();
                    jobj1 = (JSONObject)parse.parse(inline.toString());
                    JSONObject jsonObject = new JSONObject();

                    jsonObject.put("movieId",jobj1.get("id"));
                    jsonObject.put("movieName",jobj1.get("title"));
                    jsonObject.put("imdbId",jobj1.get("imdb_id"));
                    jsonObject.put("overview",jobj1.get("overview"));
                    jsonObject.put("posterSRC",jobj1.get("poster_path"));
                    jsonObject.put("runtime",jobj1.get("runtime"));
                    jsonObject.put("imdbRating",jobj1.get("vote_average"));
                    jsonObject.put("releaseDate",jobj1.get("release_date"));
                    jsonObject.put("revenue",jobj1.get("revenue"));
                    jsonObject.put("releaseStatus",jobj1.get("status"));

                    movie.setMovieId((Long) jsonObject.get("movieId"));
                    movie.setMovieName((String) jsonObject.get("movieName"));
                    movie.setImdbId((String) jsonObject.get("imdbId"));
                    movie.setOverview((String) jsonObject.get("overview"));
                    movie.setPosterSRC((String) jsonObject.get("posterSRC"));
                    movie.setRuntime((Long) jsonObject.get("runtime"));
                    movie.setImdbRating((Double) jsonObject.get("imdbRating"));
                    movie.setReleaseDate((String) jsonObject.get("releaseDate"));
                    movie.setRevenue((Long) jsonObject.get("revenue"));
                    movie.setReleaseStatus((String) jsonObject.get("releaseStatus"));

                    movieRepository.save(movie);
                    jsonArray.add(jsonObject);
                }
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

//    @GetMapping("/api/movie/upcoming")
//    public void getUpcomingMovies()

    @PostMapping("/api/like/movie/{movieId}/fan/{username}")
    public void likeMovie(
    		@PathVariable("username") String username,
    		@PathVariable("movieId") long movieId) {
    	
    	Movie movie = (Movie) movieRepository.findMovieById(movieId);
    	Fan fan = (Fan) fanRepository.findFanByUsername(username);
    	movie.likedByFan(fan);
    	movieRepository.save(movie);
    }

    @PostMapping("/api/dislike/movie/{movieId}/fan/{username}")
    public void dislikeMovie(
            @PathVariable("username") String username,
            @PathVariable("movieId") long movieId) {

        Movie movie = (Movie) movieRepository.findMovieById(movieId);
        Fan fan = (Fan) fanRepository.findFanByUsername(username);
        movie.dislikedByFan(fan);
        movieRepository.save(movie);
    }
}
