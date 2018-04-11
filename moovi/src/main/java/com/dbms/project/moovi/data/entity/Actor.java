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
    
    @Temporal(value = TemporalType.DATE)
    private Date dob;
    
    @Temporal(value = TemporalType.DATE)
    private Date dod;
    
    private String biography;
    private float actorPopularity;
    
    @ManyToMany(mappedBy="recruitedActors")
    @JsonIgnore
    private List<AdRecruiter> recruitedBy;
    
    @ManyToMany(mappedBy="actorsFollowed")
    @JsonIgnore
    private List<Fan> actorsFollowedByFans;
    
    @ManyToMany(mappedBy="listOfActors")
    @JsonIgnore
    private List<Movie> listOfMovies;

    public List<Fan> getActorsFollowedByFans() {
		return actorsFollowedByFans;
	}

	public void setActorsFollowedByFans(List<Fan> actorsFollowedByFans) {
		this.actorsFollowedByFans = actorsFollowedByFans;
	}

	public List<Fan> getActorFollowedByFans() {
        return actorsFollowedByFans;
    }

    public void setActorFollowedByFans(List<Fan> followedByFans) {
        this.actorsFollowedByFans = followedByFans;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDod() {
        return dod;
    }

    public void setDod(Date dod) {
        this.dod = dod;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public float getActorPopularity() {
        return actorPopularity;
    }

    public void setActorPopularity(float actorPopularity) {
        this.actorPopularity = actorPopularity;
    }

	public void actorRecruitedBy(AdRecruiter adRecruiter) {
		this.recruitedBy.add(adRecruiter);
        if(!adRecruiter.getRecruitedActors().contains(this)) {
        	adRecruiter.getRecruitedActors().add(this);
        }
		
	}

	public void followedBy(Fan fan) {
		this.actorsFollowedByFans.add(fan);
        if(!fan.getActorsFollowed().contains(this)) {
        	fan.getActorsFollowed().add(this);
        }
		
	}
}
