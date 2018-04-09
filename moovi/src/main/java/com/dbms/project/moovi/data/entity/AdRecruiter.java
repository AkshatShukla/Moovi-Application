package com.dbms.project.moovi.data.entity;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class AdRecruiter extends User{

    private String recruiterDescription;

    public AdRecruiter() {
        super();
    }

    public String getrecruiterDescription() {
        return recruiterDescription;
    }

    public void setrecruiterDescription(String recruiterDescription) {
        this.recruiterDescription = recruiterDescription;
    }
}
