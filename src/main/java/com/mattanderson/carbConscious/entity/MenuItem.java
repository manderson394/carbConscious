package com.mattanderson.carbConscious.entity;

import java.util.Set;

public class MenuItem {

    private int id;
    private String name;
    private MenuAPI menuApi;
    private int apiId;
    private Restaurant parentRestaurant;
    private Set<CarbohydratesEstimate> carbohydratesEstimates;
}
