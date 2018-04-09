package com.dbms.project.moovi.data.entity;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Critic extends User{

    private String criticDescription;

    private String websiteUrl;

    public Critic() {
        super();
    }

    public String getCriticDescription() {
        return criticDescription;
    }

    public void setCriticDescription(String criticDescription) {
        this.criticDescription = criticDescription;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }
}
