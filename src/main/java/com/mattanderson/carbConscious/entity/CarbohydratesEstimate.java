package com.mattanderson.carbConscious.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class CarbohydratesEstimate {

    private int id;

    @Column(name = "grams_carbohydrate_estimate")
    private int carbohydrateGramsEstimate;


    private MenuItem menuItem;


    private Outcome outcome;


    private User user;

    @Column(name = "creation_datetime")
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @Column(name = "update_datetime")
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
