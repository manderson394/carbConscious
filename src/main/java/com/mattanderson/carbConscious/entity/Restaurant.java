package com.mattanderson.carbConscious.entity;

import java.util.Set;

public class Restaurant {

    private int id;
    private String name;
    private MenuAPI menuApi;
    private int apiId;
    private Set<MenuItem> menuItems;
}
