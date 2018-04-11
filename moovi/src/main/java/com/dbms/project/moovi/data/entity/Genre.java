package com.dbms.project.moovi.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Genre {
	
	@Id
    private int genreId;
	
	@ManyToOne()
	@JsonIgnore
	private Movie movie;

	public Genre() {
		super();
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
		if(!movie.getListOfGenres().contains(this)) {
        	movie.getListOfGenres().add(this);
        }
	}

}
