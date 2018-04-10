package com.dbms.project.moovi.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Fan extends User {

    private String fanDescription;
    
    @ManyToMany
    @JoinTable(name="ActorsFollowed",
    joinColumns= @JoinColumn(name="fan_id", referencedColumnName="user_id"),
    inverseJoinColumns= @JoinColumn(name= "actor_id", referencedColumnName="actor_id"))
    @JsonIgnore
    private List<Actor> actorsFollowed;
    
    @ManyToMany
    @JoinTable(name="Like",
    joinColumns= @JoinColumn(name="fan_id", referencedColumnName="user_id"),
    inverseJoinColumns= @JoinColumn(name= "movie_id", referencedColumnName="movie_id"))
    @JsonIgnore
    private List<Movie> likedMovies;

    @ManyToMany
    @JoinTable(name = "Dislike", 
    joinColumns = @JoinColumn(name = "fan_id", referencedColumnName = "user_id"),
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
