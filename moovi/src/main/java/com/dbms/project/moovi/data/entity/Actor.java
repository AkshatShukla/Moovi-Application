package com.dbms.project.moovi.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

@Entity
public class Actor {

    @Id
    private long actorId;
    private String actorName;
    private String dob;
    private String dod;
    private String imdbId;
    private String biography;
    private String actorPopularity;

    @ManyToMany(mappedBy="recruitedActors")
    @JsonIgnore
    private List<AdRecruiter> recruitedBy;

    @ManyToMany(mappedBy="actorsFollowed")
    @JsonIgnore
    private List<Fan> fansFollowingActor;

    @ManyToMany(mappedBy="listOfActors")
    @JsonIgnore
    private List<Movie> listOfMovies;

    public List<Fan> getFansFollowingActor() {
        return fansFollowingActor;
    }

    public void setFansFollowingActor(List<Fan> fansFollowingActor) {
        this.fansFollowingActor = fansFollowingActor;
    }

    public List<AdRecruiter> getRecruitedBy() {
        return recruitedBy;
    }

    public void setRecruitedBy(List<AdRecruiter> recruitedBy) {
        this.recruitedBy = recruitedBy;
    }

    public List<Movie> getListOfMovies() {
        return listOfMovies;
    }

    public void setListOfMovies(List<Movie> listOfMovies) {
        this.listOfMovies = listOfMovies;
    }

    public Actor() {
        super();
    }

    public long getActorId() {
        return actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDod() {
        return dod;
    }

    public void setDod(String dod) {
        this.dod = dod;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getActorPopularity() {
        return actorPopularity;
    }

    public void setActorPopularity(String actorPopularity) {
        this.actorPopularity = actorPopularity;
    }

    public void actorRecruitedBy(AdRecruiter adRecruiter) {
        this.recruitedBy.add(adRecruiter);
        if(!adRecruiter.getRecruitedActors().contains(this)) {
            adRecruiter.getRecruitedActors().add(this);
        }

    }

    public void followedBy(Fan fan) {
        this.fansFollowingActor.add(fan);
        if(!fan.getActorsFollowed().contains(this)) {
            fan.getActorsFollowed().add(this);
        }

    }
}
