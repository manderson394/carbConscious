package com.mattanderson.carbConscious.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "Restaurant")
@Table(name = "RESTAURANTS")
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "source_api", referencedColumnName = "id")
    private MenuAPI menuApi;

    @Column(name = "api_id")
    private int apiId;

    @OneToMany(mappedBy = "parentRestaurant", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<MenuItem> menuItems;

    @Column(name = "creation_datetime")
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    public Restaurant() {

    }

    public Restaurant(String name, MenuAPI menuApi, int apiId, Set<MenuItem> menuItems, LocalDateTime creationDateTime) {
        this();
        this.name = name;
        this.menuApi = menuApi;
        this.apiId = apiId;
        this.menuItems = menuItems;
        this.creationDateTime = creationDateTime;
    }

    public Restaurant(int id, String name, MenuAPI menuApi, int apiId, Set<MenuItem> menuItems, LocalDateTime creationDateTime) {
        this();
        this.id = id;
        this.name = name;
        this.menuApi = menuApi;
        this.apiId = apiId;
        this.menuItems = menuItems;
        this.creationDateTime = creationDateTime;
    }
}
