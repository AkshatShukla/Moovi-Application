package com.dbms.project.moovi.data.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Review {

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

    @EmbeddedId
    private CompositePK compositePK;

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

    public CompositePK getCompositePK() {
        return compositePK;
    }

    public void setCompositePK(CompositePK compositePK) {
        this.compositePK = compositePK;
    }
}

@Embeddable
class CompositePK implements Serializable {

    //these fields should have the same type as the ID field of the corresponding entities
    //assuming Long but you have ommitted the ID fields

    private Long critic;

    private Long movie;

    //implement equals() and hashcode() as per the JPA spec
}

