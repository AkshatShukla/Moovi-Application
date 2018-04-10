package com.dbms.project.moovi.data.entity;

import org.springframework.lang.NonNull;

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
    @JoinTable(name="LIKE",
    joinColumns= @JoinColumn(name="FAN_ID", referencedColumnName="ID"),
    inverseJoinColumns= @JoinColumn(name= "MOVIE_ID", referencedColumnName="ID"))
    @JsonIgnore
    private List<Movie> likedMovies;

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
