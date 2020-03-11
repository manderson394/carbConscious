package com.mattanderson.carbConscious.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "MenuAPI")
@Table(name = "MENU_APIS")
@Data
public class MenuAPI {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String name;

    @OneToMany(mappedBy = "menuApi", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Restaurant> restaurants;

    @OneToMany(mappedBy = "menuApi", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<MenuItem> menuItems;

    @Column(name = "creation_datetime")
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    public MenuAPI() {}

    public MenuAPI(String name, Set<Restaurant> restaurants, Set<MenuItem> menuItems, LocalDateTime creationDateTime) {
        this();
        this.name = name;
        this.restaurants = restaurants;
        this.menuItems = menuItems;
        this.creationDateTime = creationDateTime;
    }

    public MenuAPI(int id, String name, Set<Restaurant> restaurants, Set<MenuItem> menuItems, LocalDateTime creationDateTime) {
        this();
        this.id = id;
        this.name = name;
        this.restaurants = restaurants;
        this.menuItems = menuItems;
        this.creationDateTime = creationDateTime;
    }
}
