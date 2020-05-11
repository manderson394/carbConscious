package com.mattanderson.carbConscious.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Defines Restaurants.
 *
 * @author Matt Anderson
 * @version 11
 */
@Entity(name = "Restaurant")
@Table(name = "RESTAURANTS")
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @NotEmpty(message = "Enter a restaurant name.")
    private String name;

    @Column(name = "street_address")
    @NotEmpty(message = "Enter a street address.")
    private String streetAddress;

    @NotEmpty(message = "Enter a state.")
    private String state;

    @Column(name = "zip_code")
    @NotEmpty(message = "Enter a zip code.")
    private String zipCode;

    @Column(name = "phone_number")
    @NotEmpty(message = "Enter a phone number.")
    //@Pattern(regex= "^[2-9]\\d{2}-\\d{3}-\\d{4}$")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "source_api", referencedColumnName = "id")
    private MenuAPI menuApi;

    @Column(name = "api_id")
    private int apiId;

    @OneToMany(mappedBy = "parentRestaurant", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = false, fetch = FetchType.EAGER)
    private Set<MenuItem> menuItems;

    @Column(name = "creation_datetime")
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    /**
     * Instantiates a new Restaurant.
     */
    public Restaurant() {
        menuItems = new HashSet<>();
    }

    /**
     * Instantiates a new Restaurant.
     *
     * @param name    the name
     * @param menuApi the menu api
     */
    public Restaurant(String name, MenuAPI menuApi) {
        this();
        this.name = name;
        this.menuApi = menuApi;
    }

    /**
     * Instantiates a new Restaurant.
     *
     * @param name    the name
     * @param menuApi the menu api
     * @param apiId   the api id
     */
    public Restaurant(String name, MenuAPI menuApi, int apiId) {
        this();
        this.name = name;
        this.menuApi = menuApi;
        this.apiId = apiId;
    }

    /**
     * Instantiates a new Restaurant.
     *
     * @param id      the id
     * @param name    the name
     * @param menuApi the menu api
     * @param apiId   the api id
     */
    public Restaurant(int id, String name, MenuAPI menuApi, int apiId) {
        this();
        this.id = id;
        this.name = name;
        this.menuApi = menuApi;
        this.apiId = apiId;
    }

    /**
     * Instantiates a new Restaurant.
     *
     * @param name          the name
     * @param streetAddress the street address
     * @param state         the state
     * @param zipCode       the zip code
     * @param phoneNumber   the phone number
     */
    public Restaurant(String name, String streetAddress, String state, String zipCode, String phoneNumber) {
        this();
        this.name = name;
        this.streetAddress = streetAddress;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Instantiates a new Restaurant.
     *
     * @param name          the name
     * @param streetAddress the street address
     * @param state         the state
     * @param zipCode       the zip code
     * @param phoneNumber   the phone number
     * @param menuApi       the menu api
     * @param apiId         the api id
     */
    public Restaurant(String name, String streetAddress, String state, String zipCode, String phoneNumber, MenuAPI menuApi, int apiId) {
        this();
        this.name = name;
        this.streetAddress = streetAddress;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.menuApi = menuApi;
        this.apiId = apiId;
    }

    /**
     * Instantiates a new Restaurant.
     *
     * @param id            the id
     * @param name          the name
     * @param streetAddress the street address
     * @param state         the state
     * @param zipCode       the zip code
     * @param phoneNumber   the phone number
     * @param menuApi       the menu api
     * @param apiId         the api id
     */
    public Restaurant(int id, String name, String streetAddress, String state, String zipCode, String phoneNumber, MenuAPI menuApi, int apiId) {
        this();
        this.id = id;
        this.name = name;
        this.streetAddress = streetAddress;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.menuApi = menuApi;
        this.apiId = apiId;
    }

    /**
     * Instantiates a new Restaurant.
     *
     * @param name             the name
     * @param streetAddress    the street address
     * @param state            the state
     * @param zipCode          the zip code
     * @param phoneNumber      the phone number
     * @param menuApi          the menu api
     * @param apiId            the api id
     * @param menuItems        the menu items
     * @param creationDateTime the creation date time
     */
    public Restaurant(String name, String streetAddress, String state, String zipCode, String phoneNumber, MenuAPI menuApi, int apiId, Set<MenuItem> menuItems, LocalDateTime creationDateTime) {
        this();
        this.name = name;
        this.streetAddress = streetAddress;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
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
     * @param streetAddress    the street address
     * @param state            the state
     * @param zipCode          the zip code
     * @param phoneNumber      the phone number
     * @param menuApi          the menu api
     * @param apiId            the api id
     * @param menuItems        the menu items
     * @param creationDateTime the creation date time
     */
    public Restaurant(int id, String name, String streetAddress, String state, String zipCode, String phoneNumber, MenuAPI menuApi, int apiId, Set<MenuItem> menuItems, LocalDateTime creationDateTime) {
        this();
        this.id = id;
        this.name = name;
        this.streetAddress = streetAddress;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
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
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", menuApi=" + menuApi +
                ", apiId=" + apiId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return id == that.id &&
                apiId == that.apiId &&
                Objects.equals(name, that.name) &&
                Objects.equals(streetAddress, that.streetAddress) &&
                Objects.equals(state, that.state) &&
                Objects.equals(zipCode, that.zipCode) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(menuApi, that.menuApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, streetAddress, state, zipCode, phoneNumber, menuApi, apiId);
    }
}
