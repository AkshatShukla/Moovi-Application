package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.Review;
import com.dbms.project.moovi.data.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping("/api/review")
    public Review createUser(@RequestBody Review review) {
        return reviewRepository.save(review);
    }
}
