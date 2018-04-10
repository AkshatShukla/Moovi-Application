package com.dbms.project.moovi.data.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Phone {
	
	private String phoneNumber;
	private boolean primary;
	
	@ManyToOne()
	@JsonIgnore
	private User PUser;
	
	public User getPUser() {
		return PUser;
	}

	public void setPUser(User pUser) {
		PUser = pUser;
	}

	public Phone() {
		super();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

}
