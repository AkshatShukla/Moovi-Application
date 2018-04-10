package com.dbms.project.moovi.data.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Theatre {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theatreId;
	
	private String theatreManagerName;
	private int totalScreens;
	private String location;
	
	@ManyToOne()
	@JsonIgnore
	private TheatreManager theatreManager;
	
	@OneToMany(mappedBy = "theatre")
    @JsonIgnore
    private List<Screen> listOfScreens;
	
	public TheatreManager getTheatreManager() {
		return theatreManager;
	}

	public void setTheatreManager(TheatreManager theatreManager) {
		this.theatreManager = theatreManager;
	}

	public List<Screen> getListOfScreens() {
		return listOfScreens;
	}

	public void setListOfScreens(List<Screen> listOfScreens) {
		this.listOfScreens = listOfScreens;
	}

	public Theatre() {
		super();
	}
	
	public int getTheatreId() {
		return theatreId;
	}
	
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	
	public String getTheatreManagerName() {
		return theatreManagerName;
	}
	
	public void setTheatreManagerName(String theatreManagerName) {
		this.theatreManagerName = theatreManagerName;
	}
	
	public int getTotalScreens() {
		return totalScreens;
	}
	
	public void setTotalScreens(int totalScreens) {
		this.totalScreens = totalScreens;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
}
