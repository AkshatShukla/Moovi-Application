package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.Critic;
import com.dbms.project.moovi.data.entity.Movie;
import com.dbms.project.moovi.data.entity.Review;
import com.dbms.project.moovi.data.repository.CriticRepository;
import com.dbms.project.moovi.data.repository.MovieRepository;
import com.dbms.project.moovi.data.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CriticRepository criticRepository;

    @PostMapping("/api/review")
    public Review createUser(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @PostMapping("/api/reviews/review/{reviewId}/movie/{movieId}")
    public void reviwedMovie(
            @PathVariable("movieId") long movieId,
            @PathVariable("reviewId") long reviewId){
        Movie movie = movieRepository.findMovieById(movieId);
        Review review = reviewRepository.findReviewById(reviewId);
        review.setRmovie(movie);
        reviewRepository.save(review);
    }

    @PostMapping("/api/reviews/review/{reviewId}/critic/{username}")
    public void reviewedByCritic(
            @PathVariable("username") String username,
            @PathVariable("reviewId") long reviewId){
        Critic critic = criticRepository.findCriticByUsername(username);
        Review review = reviewRepository.findReviewById(reviewId);
        review.setCritic(critic);
        reviewRepository.save(review);
    }
}
