package com.dbms.project.moovi.business.service;

import java.util.List;

import com.dbms.project.moovi.data.entity.Movie;
import com.dbms.project.moovi.data.entity.Review;
import com.dbms.project.moovi.data.repository.MovieRepository;
import com.dbms.project.moovi.data.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dbms.project.moovi.data.entity.Critic;
import com.dbms.project.moovi.data.repository.CriticRepository;

@RestController
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

        Movie movie = movieRepository.findMovieById(movieId);
        Critic critic = criticRepository.findCriticByUsername(username);
        critic.recommends(movie);
        criticRepository.save(critic);
    }

    @PostMapping("/api/reviews/critic/{username}/review/{reviewId}")
    public void reviewMovie(
            @PathVariable("username") String username,
            @PathVariable("reviewId") long reviewId) {
        Critic critic = criticRepository.findCriticByUsername(username);
        Review review = reviewRepository.findReviewById(reviewId);
        critic.reviews(review);
        criticRepository.save(critic);
    }
}
