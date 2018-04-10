package com.dbms.project.moovi.data.entity;

import javax.persistence.*;

@Entity
public class Review {

    @EmbeddedId
    private ReviewCompositePK compositePK;

    @Column(columnDefinition = "TEXT")
    private String review;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @MapsId("critic")
    @ManyToOne
    @JoinColumn(name = "critic_id", referencedColumnName = "userId")
    private Critic critic;

    @MapsId("movie")
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movieId")
    private Movie Rmovie;

    public Review() {
        super();
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
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


