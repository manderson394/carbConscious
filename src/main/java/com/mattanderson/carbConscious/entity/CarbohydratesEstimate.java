package com.mattanderson.carbConscious.entity;

import lombok.Data;
import org.apache.taglibs.standard.lang.jstl.UnaryMinusOperator;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    public CarbohydratesEstimate() {

    }

    public CarbohydratesEstimate(int carbohydrateGramsEstimate, MenuItem menuItem, Outcome outcome, User user, LocalDateTime creationDateTime, LocalDateTime updateDateTime) {
        this();
        this.carbohydrateGramsEstimate = carbohydrateGramsEstimate;
        this.menuItem = menuItem;
        this.outcome = outcome;
        this.user = user;
        this.creationDateTime = creationDateTime;
        this.updateDateTime = updateDateTime;
    }

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
}
