package com.mattanderson.carbConscious.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

/**
 * The type Restaurant.
 */
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

    /**
     * Instantiates a new Restaurant.
     */
    public Restaurant() {

    }

    /**
     * Instantiates a new Restaurant.
     *
     * @param name             the name
     * @param menuApi          the menu api
     * @param apiId            the api id
     * @param menuItems        the menu items
     * @param creationDateTime the creation date time
     */
    public Restaurant(String name, MenuAPI menuApi, int apiId, Set<MenuItem> menuItems, LocalDateTime creationDateTime) {
        this();
        this.name = name;
        this.menuApi = menuApi;
        this.apiId = apiId;
        this.menuItems = menuItems;
        this.creationDateTime = creationDateTime;
    }

    /**
     * Instantiates a new Restaurant.
     *
     * @param id               the id
     * @param name             the name
     * @param menuApi          the menu api
     * @param apiId            the api id
     * @param menuItems        the menu items
     * @param creationDateTime the creation date time
     */
    public Restaurant(int id, String name, MenuAPI menuApi, int apiId, Set<MenuItem> menuItems, LocalDateTime creationDateTime) {
        this();
        this.id = id;
        this.name = name;
        this.menuApi = menuApi;
        this.apiId = apiId;
        this.menuItems = menuItems;
        this.creationDateTime = creationDateTime;
    }

    /**
     * Add menu item.
     *
     * @param menuItem the menu item
     */
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    /**
     * Remove menu item.
     *
     * @param menuItem the menu item
     */
    public void removeMenuItem(MenuItem menuItem) {
        menuItems.remove(menuItem);
        menuItem.setParentRestaurant(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return id == that.id &&
                apiId == that.apiId &&
                Objects.equals(name, that.name) &&
                Objects.equals(menuApi, that.menuApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, menuApi, apiId);
    }
}
