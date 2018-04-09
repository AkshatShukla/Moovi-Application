package com.dbms.project.moovi.data.entity;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;

@Entity
public class Fan extends User {

    private String fanDescription;

    public Fan() {
        super();
    }

    public String getFanDescription() {
        return fanDescription;
    }

    public void setFanDescription(String fanDescription) {
        this.fanDescription = fanDescription;
    }
}
