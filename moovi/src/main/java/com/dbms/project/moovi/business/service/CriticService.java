package com.dbms.project.moovi.business.service;

import java.util.List;

import com.dbms.project.moovi.data.entity.Movie;
import com.dbms.project.moovi.data.entity.Review;
import com.dbms.project.moovi.data.repository.MovieRepository;
import com.dbms.project.moovi.data.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dbms.project.moovi.data.entity.Actor;
import com.dbms.project.moovi.data.entity.Critic;
import com.dbms.project.moovi.data.entity.Fan;
import com.dbms.project.moovi.data.repository.CriticRepository;

@RestController
@CrossOrigin
public class CriticService extends Utils {
	
	@Autowired
    private CriticRepository criticRepository;

	@Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewRepository reviewRepository;
	
	@PostMapping("/api/critic")
	public Critic createCritic(@RequestBody Critic critic) {
		return criticRepository.save(critic);
    }
	
	@GetMapping("/api/critic")
    public List<Critic> findAllCritics(
    		@RequestParam(name = "username", required = false) String username) {
        if (username != null)
            return (List<Critic>) criticRepository.findCriticByUsername(username);
        return (List<Critic>) criticRepository.findAll();
    }
	
	@PostMapping("/api/recommend/critic/{username}/movie/{movieId}")
    public void recommendMovie(
            @PathVariable("username") String username,
            @PathVariable("movieId") long movieId) {
        if(movieRepository.findById(movieId).isPresent()
                && criticRepository.findById(criticRepository.findCriticIdByUsername(username)).isPresent()) {
            Movie movie = movieRepository.findById(movieId).get();
            Critic critic = criticRepository.findById(criticRepository.findCriticIdByUsername(username)).get();
            critic.recommends(movie);
            criticRepository.save(critic);
        }
    }

    @PostMapping("/api/reviews/critic/{username}/review/{reviewId}")
    public void reviewMovie(
            @PathVariable("username") String username,
            @PathVariable("reviewId") long reviewId) {
	    if(criticRepository.findById(criticRepository.findCriticIdByUsername(username)).isPresent()
                && reviewRepository.findById(reviewId).isPresent()) {
            Critic critic = criticRepository.findById(criticRepository.findCriticIdByUsername(username)).get();
            Review review = reviewRepository.findById(reviewId).get();
            critic.reviews(review);
            criticRepository.save(critic);
        }
    }
    
    @GetMapping("/api/follow/critic/{username}/fanfollowing")
    public List<Fan> listOfFansFollowing(
            @PathVariable("username") String username) {
        if(criticRepository.findById(criticRepository.findCriticIdByUsername(username)).isPresent()) {
            Critic critic = criticRepository.findById(criticRepository.findCriticIdByUsername(username)).get();
            return critic.getFansFollowingCritics();
        }
        return null;
    }

    @GetMapping("/api/recommend/critic/{username}/recommendedmovies")
    public List<Movie> listOfRecommendedMovies(
            @PathVariable("username") String username){
        if(criticRepository.findById(criticRepository.findCriticIdByUsername(username)).isPresent()) {
            Critic critic = criticRepository.findById(criticRepository.findCriticIdByUsername(username)).get();
            return critic.getRecommendedMovies();
        }
        return null;
	}
}
