package com.dbms.project.moovi.data.entity;

import javax.persistence.*;

@Entity
public class Review {

    @Column(columnDefinition = "TEXT")
    private String review;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @MapsId("critic")
    @ManyToOne
    @JoinColumn(name = "critic_id")
    private Critic critic;

    @MapsId("movie")
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie Rmovie;

    @EmbeddedId
    private ReviewCompositePK compositePK;

    public Review() {
    }

    public String getOverview() {
        return review;
    }

    public void setOverview(String review) {
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
    }

    public Movie getRmovie() {
        return Rmovie;
    }

    public void setRmovie(Movie rmovie) {
        Rmovie = rmovie;
    }

    public ReviewCompositePK getCompositePK() {
        return compositePK;
    }

    public void setCompositePK(ReviewCompositePK compositePK) {
        this.compositePK = compositePK;
    }
}


