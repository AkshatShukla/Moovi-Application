package com.dbms.project.moovi.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

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
}
