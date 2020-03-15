package com.mattanderson.carbConscious.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Menu item.
 */
@Entity(name = "MenuItem")
@Table(name = "MENU_ITEMS")
@Data
public class MenuItem {

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

    @ManyToOne
    @JoinColumn(name = "parent_restaurant_api_id", referencedColumnName = "id")
    private Restaurant parentRestaurant;

    @OneToMany(mappedBy = "menuItem", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<CarbohydratesEstimate> carbohydratesEstimates;

    @Column(name = "creation_datetime")
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    /**
     * Instantiates a new Menu item.
     */
    public MenuItem() {
        carbohydratesEstimates = new HashSet<>();
    }

    /**
     * Instantiates a new Menu item.
     *
     * @param name    the name
     * @param menuApi the menu api
     * @param apiId   the api id
     */
    public MenuItem(String name, MenuAPI menuApi, int apiId) {
        this();
        this.name = name;
        this.menuApi = menuApi;
        this.apiId = apiId;
    }

    public MenuItem(String name, MenuAPI menuApi, int apiId, Restaurant parentRestaurant) {
        this.name = name;
        this.menuApi = menuApi;
        this.apiId = apiId;
        this.parentRestaurant = parentRestaurant;
    }

    /**
     * Instantiates a new Menu item.
     *
     * @param name                   the name
     * @param menuApi                the menu api
     * @param apiId                  the api id
     * @param parentRestaurant       the parent restaurant
     * @param carbohydratesEstimates the carbohydrates estimates
     * @param creationDateTime       the creation date time
     */
    public MenuItem(String name, MenuAPI menuApi, int apiId, Restaurant parentRestaurant, Set<CarbohydratesEstimate> carbohydratesEstimates, LocalDateTime creationDateTime) {
        this();
        this.name = name;
        this.menuApi = menuApi;
        this.apiId = apiId;
        this.parentRestaurant = parentRestaurant;
        this.carbohydratesEstimates = carbohydratesEstimates;
        this.creationDateTime = creationDateTime;
    }

    /**
     * Instantiates a new Menu item.
     *
     * @param id                     the id
     * @param name                   the name
     * @param menuApi                the menu api
     * @param apiId                  the api id
     * @param parentRestaurant       the parent restaurant
     * @param carbohydratesEstimates the carbohydrates estimates
     * @param creationDateTime       the creation date time
     */
    public MenuItem(int id, String name, MenuAPI menuApi, int apiId, Restaurant parentRestaurant, Set<CarbohydratesEstimate> carbohydratesEstimates, LocalDateTime creationDateTime) {
        this();
        this.id = id;
        this.name = name;
        this.menuApi = menuApi;
        this.apiId = apiId;
        this.parentRestaurant = parentRestaurant;
        this.carbohydratesEstimates = carbohydratesEstimates;
        this.creationDateTime = creationDateTime;
    }

    /**
     * Add carbohydrates estimate.
     *
     * @param estimate the estimate
     */
    public void addCarbohydratesEstimate(CarbohydratesEstimate estimate) {
        carbohydratesEstimates.add(estimate);
    }

    /**
     * Remove carbohydrates estimate.
     *
     * @param estimate the estimate
     */
    public void removeCarbohydratesEstimate(CarbohydratesEstimate estimate) {
        carbohydratesEstimates.remove(estimate);
        estimate.setMenuItem(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return id == menuItem.id &&
                apiId == menuItem.apiId &&
                Objects.equals(name, menuItem.name) &&
                Objects.equals(menuApi, menuItem.menuApi) &&
                Objects.equals(parentRestaurant, menuItem.parentRestaurant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, menuApi, apiId, parentRestaurant);
    }
}
