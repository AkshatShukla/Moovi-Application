package com.dbms.project.moovi.data.repository;

import com.dbms.project.moovi.data.entity.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    @Query("SELECT r FROM Review r WHERE r.reviewId=:reviewId")
    Review findReviewById(@Param("reviewId") long r);
}
