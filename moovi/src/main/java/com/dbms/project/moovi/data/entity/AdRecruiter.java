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
    joinColumns= @JoinColumn(name="recruiter_id", referencedColumnName="userId"),
    inverseJoinColumns= @JoinColumn(name= "actor_id", referencedColumnName="actorId"))
    @JsonIgnore
    private List<Actor> recruitedActors;

    public AdRecruiter() {
        super();
    }

    public String getRecruiterDescription() {
        return recruiterDescription;
    }

    public void setRecruiterDescription(String recruiterDescription) {
        this.recruiterDescription = recruiterDescription;
    }

    public List<Actor> getRecruitedActors() {
        return recruitedActors;
    }

    public void setRecruitedActors(List<Actor> recruitedActors) {
        this.recruitedActors = recruitedActors;
    }

	public void recruitsActor(Actor actor) {
		this.recruitedActors.add(actor);
		if(!actor.getRecruitedBy().contains(this)) {
			actor.getRecruitedBy().add(this);
		}	
		
	}
}
