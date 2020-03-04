package com.mattanderson.carbConscious.entity;

public enum Outcome {
    HIGH(2),
    IN_RANGE(1),
    LOW(0);

    private int id;

    Outcome(int id) {
        this.id = id;
    }
}
