package com.mattanderson.carbConscious.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

/**
 * Defines Menu API.
 * @author Matt Anderson
 * @version 11
 */
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

    /**
     * Instantiates a new Menu api.
     */
    public MenuAPI() {}

    /**
     * Instantiates a new Menu api.
     *
     * @param name the name
     */
    public MenuAPI(String name) {
        this();
        this.name = name;
    }

    /**
     * Instantiates a new Menu api.
     *
     * @param name             the name
     * @param restaurants      the restaurants
     * @param menuItems        the menu items
     * @param creationDateTime the creation date time
     */
    public MenuAPI(String name, Set<Restaurant> restaurants, Set<MenuItem> menuItems, LocalDateTime creationDateTime) {
        this();
        this.name = name;
        this.restaurants = restaurants;
        this.menuItems = menuItems;
        this.creationDateTime = creationDateTime;
    }

    /**
     * Instantiates a new Menu api.
     *
     * @param id               the id
     * @param name             the name
     * @param restaurants      the restaurants
     * @param menuItems        the menu items
     * @param creationDateTime the creation date time
     */
    public MenuAPI(int id, String name, Set<Restaurant> restaurants, Set<MenuItem> menuItems, LocalDateTime creationDateTime) {
        this();
        this.id = id;
        this.name = name;
        this.restaurants = restaurants;
        this.menuItems = menuItems;
        this.creationDateTime = creationDateTime;
    }

    /**
     * Add restaurant.
     *
     * @param restaurant the restaurant
     */
    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    /**
     * Remove restaurant.
     *
     * @param restaurant the restaurant
     */
    public void removeRestaurant(Restaurant restaurant) {
        restaurants.remove(restaurant);
        restaurant.setMenuApi(null);
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
        menuItem.setMenuApi(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuAPI menuAPI = (MenuAPI) o;
        return id == menuAPI.id &&
                Objects.equals(name, menuAPI.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
