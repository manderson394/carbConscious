package com.mattanderson.carbConscious.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Defines Menu items.
 * @author Matt Anderson
 * @version 11
 */
@Entity(name = "MenuItem")
@Table(name = "MENU_ITEMS")
@Data
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @NotNull
    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "source_api", referencedColumnName = "id")
    private MenuAPI menuApi;

    @Column(name = "api_id")
    private int apiId;

    @ManyToOne
    @JoinColumn(name = "parent_restaurant_api_id", referencedColumnName = "id")
    private Restaurant parentRestaurant;

    @OneToMany(mappedBy = "menuItem", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = false, fetch = FetchType.EAGER)
    private Set<CarbohydratesEstimate> carbohydratesEstimates;

    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<UserFavorite> favorites;

    @Column(name = "creation_datetime")
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    /**
     * Instantiates a new Menu item.
     */
    public MenuItem() {
        carbohydratesEstimates = new HashSet<>();
        favorites = new HashSet<>();
    }

    /**
     * Instantiates a new Menu item.
     *
     * @param name             the name
     * @param description      the description
     * @param parentRestaurant the parent restaurant
     */
    public MenuItem(String name, String description, Restaurant parentRestaurant) {
        this();
        this.name = name;
        if (description.isEmpty()) {
            this.description = "Description not available";
        } else {
            this.description = description;
        }
        this.parentRestaurant = parentRestaurant;
    }

    /**
     * Instantiates a new Menu item.
     *
     * @param name        the name
     * @param description the description
     * @param menuApi     the menu api
     * @param apiId       the api id
     */
    public MenuItem(String name, String description, MenuAPI menuApi, int apiId) {
        this();
        this.name = name;
        if (description.isEmpty()) {
            this.description = "Description not available";
        } else {
            this.description = description;
        }
        this.menuApi = menuApi;
        this.apiId = apiId;
    }

    /**
     * Instantiates a new Menu item.
     *
     * @param name             the name
     * @param description      the description
     * @param menuApi          the menu api
     * @param apiId            the api id
     * @param parentRestaurant the parent restaurant
     */
    public MenuItem(String name, String description, MenuAPI menuApi, int apiId, Restaurant parentRestaurant) {
        this();
        this.name = name;
        if (description.isEmpty()) {
            this.description = "Description not available";
        } else {
            this.description = description;
        }
        this.menuApi = menuApi;
        this.apiId = apiId;
        this.parentRestaurant = parentRestaurant;
    }

    /**
     * Instantiates a new Menu item.
     *
     * @param id               the id
     * @param name             the name
     * @param description      the description
     * @param menuApi          the menu api
     * @param apiId            the api id
     * @param parentRestaurant the parent restaurant
     */
    public MenuItem(int id, String name, String description, MenuAPI menuApi, int apiId, Restaurant parentRestaurant) {
        this();
        this.name = name;
        if (description.isEmpty()) {
            this.description = "Description not available";
        } else {
            this.description = description;
        }
        this.id = id;
        this.menuApi = menuApi;
        this.apiId = apiId;
        this.parentRestaurant = parentRestaurant;
    }

    /**
     * Instantiates a new Menu item.
     *
     * @param name                   the name
     * @param description            the description
     * @param menuApi                the menu api
     * @param apiId                  the api id
     * @param parentRestaurant       the parent restaurant
     * @param carbohydratesEstimates the carbohydrates estimates
     * @param favorites              the favorites
     * @param creationDateTime       the creation date time
     */
    public MenuItem(String name, String description, MenuAPI menuApi, int apiId, Restaurant parentRestaurant, Set<CarbohydratesEstimate> carbohydratesEstimates, Set<UserFavorite> favorites, LocalDateTime creationDateTime) {
        this();
        this.name = name;
        if (description.isEmpty()) {
            this.description = "Description not available";
        } else {
            this.description = description;
        }
        this.menuApi = menuApi;
        this.apiId = apiId;
        this.parentRestaurant = parentRestaurant;
        this.carbohydratesEstimates = carbohydratesEstimates;
        this.favorites = favorites;
        this.creationDateTime = creationDateTime;
    }

    /**
     * Instantiates a new Menu item.
     *
     * @param id                     the id
     * @param name                   the name
     * @param description            the description
     * @param menuApi                the menu api
     * @param apiId                  the api id
     * @param parentRestaurant       the parent restaurant
     * @param carbohydratesEstimates the carbohydrates estimates
     * @param favorites              the favorites
     * @param creationDateTime       the creation date time
     */
    public MenuItem(int id, String name, String description, MenuAPI menuApi, int apiId, Restaurant parentRestaurant, Set<CarbohydratesEstimate> carbohydratesEstimates, Set<UserFavorite> favorites, LocalDateTime creationDateTime) {
        this();
        this.id = id;
        this.name = name;
        this.description = description;
        this.menuApi = menuApi;
        this.apiId = apiId;
        this.parentRestaurant = parentRestaurant;
        this.carbohydratesEstimates = carbohydratesEstimates;
        this.favorites = favorites;
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

    /**
     * Add favorite.
     *
     * @param favorite the favorite
     */
    public void addFavorite(UserFavorite favorite) {
        favorites.add(favorite);
    }

    /**
     * Remove favorite.
     *
     * @param favorite the favorite
     */
    public void removeFavorite(UserFavorite favorite) {
        favorites.remove(favorite);
        favorite.setMenuItem(null);
    }


    /**
     * Calculate average of all carbohydrates estimates for the menu item as an integer.
     *
     * @return the int
     */
    public int calculateAverageCarbohydratesEstimate() {
        double sum = 0;
        for (CarbohydratesEstimate carbEst : carbohydratesEstimates) {
            sum += carbEst.getCarbohydrateGramsEstimate();
        }
        double average = sum / carbohydratesEstimates.size();
        return (int) Math.round(average);
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", menuApi=" + menuApi +
                ", apiId=" + apiId +
                ", parentRestaurant=" + parentRestaurant +
                ", creationDateTime=" + creationDateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return id == menuItem.id &&
                apiId == menuItem.apiId &&
                Objects.equals(name, menuItem.name) &&
                Objects.equals(description, menuItem.description) &&
                Objects.equals(menuApi, menuItem.menuApi) &&
                Objects.equals(parentRestaurant, menuItem.parentRestaurant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, menuApi, apiId, parentRestaurant);
    }
}
