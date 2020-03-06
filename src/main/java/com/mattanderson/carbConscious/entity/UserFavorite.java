package com.mattanderson.carbConscious.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "UserFavorite")
@Table(name = "USER_FAVORITES")
@Data
public class UserFavorite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "favorites_line")
    private int line;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "menu_item_id", referencedColumnName = "id")
    private MenuItem menuItem;

    public UserFavorite() {

    }

    public UserFavorite(int line, User user, MenuItem menuItem) {
        this();
        this.line = line;
        this.user = user;
        this.menuItem = menuItem;
    }

    public UserFavorite(int id, int line, User user, MenuItem menuItem) {
        this();
        this.id = id;
        this.line = line;
        this.user = user;
        this.menuItem = menuItem;
    }
}
