package com.mattanderson.carbConscious.entity;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import javax.persistence.Entity;
import javax.persistence.Table;

@Log4j2
public enum Outcome {
    HIGH(2),
    IN_RANGE(1),
    LOW(0);

    @Getter
    private int id;

    Outcome(int id) {
        this.id = id;
    }

    public static Outcome fromId(int id) {
        for (Outcome outcome : Outcome.values()) {
            if (outcome.getId() == id) {
                return outcome;
            }
        }
        log.debug("Unsupported outcome selected: " + id);
        throw new UnsupportedOperationException("The outcome" + id + "is not supported.");
    }
}
