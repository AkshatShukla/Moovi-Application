package com.dbms.project.moovi.data.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int movie_id;

    @NotBlank
    String name;

    @NonNull
    String imdbId;

    String overview;

    String posterSRC;

    int runtime;

    float imdbRating;

    @Temporal(value = TemporalType.DATE)
    Date releaseDate;

    int revenue;

    Boolean releaseStatus;

    public Movie() {
        super();
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(float imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public Boolean getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(Boolean releaseStatus) {
        this.releaseStatus = releaseStatus;
    }
}
