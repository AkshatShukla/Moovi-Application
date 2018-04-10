package com.dbms.project.moovi.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Fan extends User {

    private String fanDescription;

    @ManyToMany
    @JoinTable(name = "Dislike", joinColumns = @JoinColumn(name = "fan_id", referencedColumnName = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "movie_id"))
    @JsonIgnore
    private List<Movie> dislikedMovies;

    public Fan() {
        super();
    }

    public String getFanDescription() {
        return fanDescription;
    }

    public void setFanDescription(String fanDescription) {
        this.fanDescription = fanDescription;
    }
}
