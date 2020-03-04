package com.mattanderson.carbConscious.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Set;

public class Restaurant {

    private int id;
    private String name;
    private MenuAPI menuApi;
    private int apiId;
    private Set<MenuItem> menuItems;

    @Column(name = "creation_datetime")
    @CreationTimestamp
    private LocalDateTime creationDateTime;
}
