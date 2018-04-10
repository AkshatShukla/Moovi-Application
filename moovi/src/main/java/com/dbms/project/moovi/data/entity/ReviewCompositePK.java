package com.dbms.project.moovi.data.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReviewCompositePK implements Serializable {

    //these fields should have the same type as the ID field of the corresponding entities
    //assuming Long but you have ommitted the ID fields

    @Column(name = "critic_id")
    private long critic;

    @Column(name = "movie_id")
    private long movie;

    public ReviewCompositePK() {
    }

    public long getCritic() {
        return critic;
    }

    public void setCritic(long critic) {
        this.critic = critic;
    }

    public long getMovie() {
        return movie;
    }

    public void setMovie(long movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ReviewCompositePK that = (ReviewCompositePK) o;
        return critic == that.critic &&
                movie == that.movie;
    }

    @Override
    public int hashCode() {

        return Objects.hash(critic, movie);
    }
}
