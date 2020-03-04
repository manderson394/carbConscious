package com.mattanderson.carbConscious.entity;

import java.time.LocalDateTime;
import java.util.Set;

public class MenuAPI {

    private int id;
    private String name;
    private Set<Restaurant> restaurants;
    private Set<MenuItem> menuItems;
    private LocalDateTime creationDateTime;
}
