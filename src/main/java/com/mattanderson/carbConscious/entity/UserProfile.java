package com.mattanderson.carbConscious.entity;

import java.util.Set;

public class UserProfile {

    private int id;
    private String name;
    private User user;
    private Set<UserFavorites> favorites;
    private Set<CarbohydratesEstimate> carbohydratesEstimates;
}