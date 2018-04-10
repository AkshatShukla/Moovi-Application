package com.dbms.project.moovi.data.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {
	
	private String street;	
	private String city;	
	private String state;
	private String zip;	
	private boolean primary;	
	
	@ManyToOne()
	@JsonIgnore
	private User AUser;
	
	public User getAUser() {
		return AUser;
	}

	public void setAUser(User aUser) {
		AUser = aUser;
	}

	public Address() {
		super();
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

}
