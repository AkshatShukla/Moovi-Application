package com.dbms.project.moovi.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class AdRecruiter extends User{

    private String recruiterDescription;
    
    @ManyToMany
    @JoinTable(name="Recruit",
    joinColumns= @JoinColumn(name="recruiter_id", referencedColumnName="user_id"),
    inverseJoinColumns= @JoinColumn(name= "actor_id", referencedColumnName="actor_id"))
    @JsonIgnore
    private List<Actor> recruitedActors;

    public AdRecruiter() {
        super();
    }

    public String getrecruiterDescription() {
        return recruiterDescription;
    }

    public void setrecruiterDescription(String recruiterDescription) {
        this.recruiterDescription = recruiterDescription;
    }
}
