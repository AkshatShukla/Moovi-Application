package com.dbms.project.moovi.data.repository;

import com.dbms.project.moovi.data.entity.Review;
import com.dbms.project.moovi.data.entity.ReviewCompositePK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends CrudRepository<Review, ReviewCompositePK> {

    @Query("SELECT r FROM Review r WHERE r.Rmovie.movieId=:movieId")
    Iterable<Review> findReviewByMovieId(@Param("movieId") long movieId);
}
