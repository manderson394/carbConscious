package com.mattanderson.carbConscious.entity;

public class CarbohydratesEstimate {

    private int id;
    private int carbohydrateGramsEstimate;
    private MenuItem menuItem;
    private enum outcome {
        HIGH, IN_RANGE, LOW
    }
    private User user;
}
