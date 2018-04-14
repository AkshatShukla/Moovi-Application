package com.dbms.project.moovi.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Screen {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long screenId;
	
	@ManyToOne()
	@JsonIgnore
	private Movie screenHasMovie;
	
	@ManyToOne()
	@JsonIgnore
	private Theatre theatre;

	public Screen() {
		super();
	}

	public long getScreenId() {
		return screenId;
	}

	public void setScreenId(long screenId) {
		this.screenId = screenId;
	}

	public Movie getScreenHasMovie() {
		return screenHasMovie;
	}

	public void setScreenHasMovie(Movie screenHasMovie) {
		this.screenHasMovie = screenHasMovie;
		if(!screenHasMovie.getMoviePlayingInScreen().contains(this)) {
			screenHasMovie.getMoviePlayingInScreen().add(this);
		}
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
		if(!theatre.getListOfScreens().contains(this)){
			theatre.getListOfScreens().add(this);
		}
	}

}
