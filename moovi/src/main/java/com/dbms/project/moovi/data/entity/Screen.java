package com.dbms.project.moovi.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Screen {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screenId;
	
	@OneToOne(mappedBy = "moviePlayingInScreen")
	@JsonIgnore
	private Movie screenHasMovie;
	
	@ManyToOne()
	@JsonIgnore
	private Theatre theatre;

	public Screen() {
		super();
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

//	public Movie getScreenHasMovie() {
//		return screenHasMovie;
//	}
//
//	public void setScreenHasMovie(Movie screenHasMovie) {
//		this.screenHasMovie = screenHasMovie;
//	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

}
