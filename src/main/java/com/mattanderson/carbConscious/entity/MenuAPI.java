package com.mattanderson.carbConscious.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Set;

public class MenuAPI {

    private int id;

    private String name;


    private Set<Restaurant> restaurants;


    private Set<MenuItem> menuItems;

    @Column(name = "creation_datetime")
    @CreationTimestamp
    private LocalDateTime creationDateTime;
}
