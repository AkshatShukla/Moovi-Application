//package com.dbms.project.moovi.business.service;
//
//import com.dbms.project.moovi.data.entity.Review;
//import com.dbms.project.moovi.data.repository.ReviewRepository;
//import com.sun.org.apache.regexp.internal.RE;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class ReviewService {
//
//    @Autowired
//    private ReviewRepository reviewRepository;
//
//    @PostMapping("/api/review")
//    public Review createUser(@RequestBody Review review) {
//        return reviewRepository.save(review);
//    }
//
//    @GetMapping("/api/review")
//    public List<Review> findAllReview(){
//        return (List<Review>) reviewRepository.findAll();
//    }
//
//    @GetMapping("/api/review/{movieId}")
//    public List<Review> findAllReviewByMovieId(@PathVariable(name = "movieId") long movieId){
//        return (List<Review>) reviewRepository.findReviewByMovieId(movieId);
//    }
//}
