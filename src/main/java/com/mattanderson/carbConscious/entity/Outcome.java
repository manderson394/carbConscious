package com.mattanderson.carbConscious.entity;

public class Outcome {

    private int id;
    private enum outcome {
        HIGH, IN_RANGE, LOW
    }
    private String comment;
    private CarbohydratesEstimate carbohydratesEstimate;
}
