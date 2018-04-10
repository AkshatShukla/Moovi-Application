package com.dbms.project.moovi.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Movie {

    @Id
    private long movieId;
    private String movieName;
    private String imdbId;
    @Column(columnDefinition = "TEXT")
    private String overview;
    private String posterSRC;
    private long runtime;
    private double imdbRating;
    private String releaseDate;
    private long revenue;
    private String releaseStatus;
    
    @ManyToMany(mappedBy = "recommendedMovies")
    @JsonIgnore
    private List<Critic> recommendedBy;
    
    @ManyToMany(mappedBy = "likesMovies")
    @JsonIgnore
    private List<Fan> likedByFans;

    @ManyToMany(mappedBy = "dislikesMovies")
    @JsonIgnore
    private List<Fan> dislikedByFans;
    
    @ManyToMany
    @JoinTable(name = "MovieCast", 
    joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "movieId"),
    inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actorId"))
    @JsonIgnore
    private List<Actor> listOfActors;

    public Movie() {
        super();
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String name) {
        this.movieName = name;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterSRC() {
        return posterSRC;
    }

    public void setPosterSRC(String posterSRC) {
        this.posterSRC = posterSRC;
    }

    public long getRuntime() {
        return runtime;
    }

    public void setRuntime(long runtime) {
        this.runtime = runtime;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public String getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
    }
}
