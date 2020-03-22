package com.mattanderson.carbConscious.entity;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Defines the Outcome enumeration.
 * @author Matt Anderson
 * @version 11
 */
@Log4j2
public enum Outcome {
    /**
     * High outcome.
     */
    HIGH(2),
    /**
     * In range outcome.
     */
    IN_RANGE(1),
    /**
     * Low outcome.
     */
    LOW(0);

    @Getter
    private int id;

    Outcome(int id) {
        this.id = id;
    }

    /**
     * Gets the outcome enumeration from an ID.
     *
     * @param id the id
     * @return the outcome
     */
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
