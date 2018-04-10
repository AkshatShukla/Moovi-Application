package com.dbms.project.moovi.data.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Critic extends User{

    private String criticDescription;

    private String websiteUrl;
    
    @ManyToMany
    @JoinTable(name="Recommend",
    joinColumns= @JoinColumn(name="critic_id", referencedColumnName="userId"),
    inverseJoinColumns= @JoinColumn(name= "movie_id", referencedColumnName="movieId"))
    @JsonIgnore
    private List<Movie> recommendedMovies;
    
    @ManyToMany(mappedBy = "criticsFollowed")
    @JsonIgnore
    private List<Fan> followedBy;

    public Critic() {
        super();
    }

    public List<Movie> getRecommendedMovies() {
        return recommendedMovies;
    }

    public void setRecommendedMovies(List<Movie> recommendedMovies) {
        this.recommendedMovies = recommendedMovies;
    }

    public List<Fan> getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(List<Fan> followedBy) {
        this.followedBy = followedBy;
    }

    public String getCriticDescription() {
        return criticDescription;
    }

    public void setCriticDescription(String criticDescription) {
        this.criticDescription = criticDescription;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }
}
