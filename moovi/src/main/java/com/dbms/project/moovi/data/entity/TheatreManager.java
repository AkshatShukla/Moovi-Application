package com.dbms.project.moovi.data.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TheatreManager extends User {
	
	@OneToMany(mappedBy = "theatreManager")
    @JsonIgnore
    private List<Theatre> listOfTheatresManaged;
	
	public TheatreManager() {
		super();
	}

	public List<Theatre> getListOfTheatresManaged() {
		return listOfTheatresManaged;
	}

	public void setListOfTheatresManaged(List<Theatre> listOfTheatresManaged) {
		this.listOfTheatresManaged = listOfTheatresManaged;
	}

	public void managedTheatres(Theatre theatre){
		this.listOfTheatresManaged.add(theatre);
		if(theatre.getTheatreManager() != this)
			theatre.setTheatreManager(this);
	}
}

