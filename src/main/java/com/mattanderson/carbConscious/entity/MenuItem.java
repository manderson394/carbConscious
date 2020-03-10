package com.mattanderson.carbConscious.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "MenuItem")
@Table(name = "MENU_ITEMS")
@Data
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String name;

    //@Column(name = "source_api")
    //@ManyToOne
    //@JoinColumn
    //private MenuAPI menuApi;

    @Column(name = "api_id")
    private int apiId;

    //@Column(name = "parent_restaurant_api_id")
    //private Restaurant parentRestaurant;

    @OneToMany(mappedBy = "menuItem", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<CarbohydratesEstimate> carbohydratesEstimates;

    @Column(name = "creation_datetime")
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    public MenuItem() {

    }

    public MenuItem(String name, int apiId, Set<CarbohydratesEstimate> carbohydratesEstimates, LocalDateTime creationDateTime) {
        this();
        this.name = name;
        this.apiId = apiId;
        this.carbohydratesEstimates = carbohydratesEstimates;
        this.creationDateTime = creationDateTime;
    }

    public MenuItem(int id, String name, int apiId, Set<CarbohydratesEstimate> carbohydratesEstimates, LocalDateTime creationDateTime) {
        this();
        this.id = id;
        this.name = name;
        this.apiId = apiId;
        this.carbohydratesEstimates = carbohydratesEstimates;
        this.creationDateTime = creationDateTime;
    }
}
