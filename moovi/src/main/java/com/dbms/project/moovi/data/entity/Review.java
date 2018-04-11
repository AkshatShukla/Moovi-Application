package com.dbms.project.moovi.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "TEXT")
    private String review;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @ManyToOne()
    @JoinColumn(name = "critic_id")
    @JsonIgnore
    private Critic critic;

    @ManyToOne()
    @JoinColumn(name = "movie_id")
    @JsonIgnore
    private Movie rmovie;

    public Review() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Critic getCritic() {
        return critic;
    }

    public void setCritic(Critic critic) {
        this.critic = critic;
        if(!critic.getReviewedMovie().contains(this))
            critic.getReviewedMovie().add(this);
    }

    public Movie getRmovie() {
        return rmovie;
    }

    public void setRmovie(Movie rmovie) {
        this.rmovie = rmovie;
        if(!rmovie.getMovieReview().contains(this))
            rmovie.getMovieReview().add(this);
    }
}


