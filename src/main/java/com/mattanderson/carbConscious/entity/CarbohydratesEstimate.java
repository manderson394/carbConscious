package com.mattanderson.carbConscious.entity;

import lombok.Data;
import org.apache.taglibs.standard.lang.jstl.UnaryMinusOperator;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The type Carbohydrates estimate.
 */
@Entity(name = "CarbohydratesEstimate")
@Table(name = "CARBOHYDRATE_ESTIMATES")
@Data
public class CarbohydratesEstimate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "grams_carbohydrate_estimate")
    private int carbohydrateGramsEstimate;

    @ManyToOne
    @JoinColumn(name = "menu_item_id", referencedColumnName = "id")
    private MenuItem menuItem;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "outcome_id")
    private Outcome outcome;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "creation_datetime")
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @Column(name = "update_datetime")
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    /**
     * Instantiates a new Carbohydrates estimate.
     */
    public CarbohydratesEstimate() {

    }

    /**
     * Instantiates a new Carbohydrates estimate.
     *
     * @param carbohydrateGramsEstimate the carbohydrate grams estimate
     * @param menuItem                  the menu item
     * @param outcome                   the outcome
     * @param user                      the user
     */
    public CarbohydratesEstimate(int carbohydrateGramsEstimate, MenuItem menuItem, Outcome outcome, User user) {
        this.carbohydrateGramsEstimate = carbohydrateGramsEstimate;
        this.menuItem = menuItem;
        this.outcome = outcome;
        this.user = user;
    }

    /**
     * Instantiates a new Carbohydrates estimate.
     *
     * @param carbohydrateGramsEstimate the carbohydrate grams estimate
     * @param menuItem                  the menu item
     * @param outcome                   the outcome
     * @param user                      the user
     * @param creationDateTime          the creation date time
     * @param updateDateTime            the update date time
     */
    public CarbohydratesEstimate(int carbohydrateGramsEstimate, MenuItem menuItem, Outcome outcome, User user, LocalDateTime creationDateTime, LocalDateTime updateDateTime) {
        this();
        this.carbohydrateGramsEstimate = carbohydrateGramsEstimate;
        this.menuItem = menuItem;
        this.outcome = outcome;
        this.user = user;
        this.creationDateTime = creationDateTime;
        this.updateDateTime = updateDateTime;
    }

    /**
     * Instantiates a new Carbohydrates estimate.
     *
     * @param id                        the id
     * @param carbohydrateGramsEstimate the carbohydrate grams estimate
     * @param menuItem                  the menu item
     * @param outcome                   the outcome
     * @param user                      the user
     * @param creationDateTime          the creation date time
     * @param updateDateTime            the update date time
     */
    public CarbohydratesEstimate(int id, int carbohydrateGramsEstimate, MenuItem menuItem, Outcome outcome, User user, LocalDateTime creationDateTime, LocalDateTime updateDateTime) {
        this();
        this.id = id;
        this.carbohydrateGramsEstimate = carbohydrateGramsEstimate;
        this.menuItem = menuItem;
        this.outcome = outcome;
        this.user = user;
        this.creationDateTime = creationDateTime;
        this.updateDateTime = updateDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarbohydratesEstimate that = (CarbohydratesEstimate) o;
        return id == that.id &&
                carbohydrateGramsEstimate == that.carbohydrateGramsEstimate &&
                Objects.equals(menuItem, that.menuItem) &&
                outcome == that.outcome &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carbohydrateGramsEstimate, menuItem, outcome, user);
    }
}
