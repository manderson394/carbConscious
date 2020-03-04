package com.mattanderson.carbConscious.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Set;

public class MenuItem {

    private int id;

    private String name;


    private MenuAPI menuApi;

    @Column(name = "api_id")
    private int apiId;


    private Restaurant parentRestaurant;


    private Set<CarbohydratesEstimate> carbohydratesEstimates;

    @Column(name = "creation_datetime")
    @CreationTimestamp
    private LocalDateTime creationDateTime;
}
