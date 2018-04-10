package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.Actor;
import com.dbms.project.moovi.data.entity.Fan;
import com.dbms.project.moovi.data.entity.Movie;
import com.dbms.project.moovi.data.repository.ActorRepository;
import com.dbms.project.moovi.data.repository.FanRepository;
import com.dbms.project.moovi.data.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FanService extends Utils {

    @Autowired
    private FanRepository fanRepository;

    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private ActorRepository actorRepository;

    @PostMapping("/api/fan")
    public Fan createFan(@RequestBody Fan fan) {
        return fanRepository.save(fan);
    }

    @SuppressWarnings("unchecked")
	@GetMapping("/api/fan")
    public List<Fan> findAllFans(@RequestParam(name = "username", required = false) String username) {
        if (username != null)
            return (List<Fan>) fanRepository.findFanByUsername(username);
        return (List<Fan>) fanRepository.findAll();
    }

    @PostMapping("api/like/fan/{username}/movie/{movieId}")
    public void fanLikesMovie(
            @PathVariable("username") String username,
            @PathVariable("movieId") long movieId){
        Movie movie = (Movie) movieRepository.findMovieById(movieId);
        Fan fan = (Fan) fanRepository.findFanByUsername(username);
        fan.likesMovie(movie);
        fanRepository.save(fan);
    }

    @PostMapping("api/dislike/fan/{username}/movie/{movieId}")
    public void fanDislikesMovie(
            @PathVariable("username") String username,
            @PathVariable("movieId") long movieId){
        Movie movie = (Movie) movieRepository.findMovieById(movieId);
        Fan fan = (Fan) fanRepository.findFanByUsername(username);
        fan.dislikesMovie(movie);
        fanRepository.save(fan);
    }

    @PostMapping("api/follow/fan/{username}/actor/{actorId}")
    public void fanFollowsActor(
            @PathVariable("username") String username,
            @PathVariable("actorId") long actorId){

		Actor actor = (Actor) actorRepository.findActorById(actorId);
        Fan fan = (Fan) fanRepository.findFanByUsername(username);
        fan.followsActor(actor);
        fanRepository.save(fan);
    }
}
