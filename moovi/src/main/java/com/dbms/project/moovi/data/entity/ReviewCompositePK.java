package com.dbms.project.moovi.data.entity;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReviewCompositePK implements Serializable {

    //these fields should have the same type as the ID field of the corresponding entities
    //assuming Long but you have ommitted the ID fields

    private long critic;

    private long movie;

    //implement equals() and hashcode() as per the JPA spec
}
