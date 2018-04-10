package com.dbms.project.moovi.data.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TheatreManager extends User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theatreManagerId;
	
	@OneToMany(mappedBy = "theatreManager")
    @JsonIgnore
    private List<Theatre> listOfTheatresManaged;
	
	public TheatreManager() {
		super();
	}
	
	public List<Theatre> getTheatresManaged() {
		return listOfTheatresManaged;
	}

	public void setTheatresManaged(List<Theatre> listOfTheatresManaged) {
		this.listOfTheatresManaged = listOfTheatresManaged;
	}

	public int getTheatreManagerId() {
		return theatreManagerId;
	}

	public void setTheatreManagerId(int theatreManagerId) {
		this.theatreManagerId = theatreManagerId;
	}
	

}
