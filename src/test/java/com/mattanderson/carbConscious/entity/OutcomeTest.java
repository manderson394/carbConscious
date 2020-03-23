package com.mattanderson.carbConscious.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Tests the <code>Outcome</code> enumeration.
 * @author Matt Anderson
 * @version 11
 */
class OutcomeTest {

    private Outcome outcome;

    /**
     * Sets up the instance variable before each unit test.
     */
    @BeforeEach
    void setUp() {
        outcome = Outcome.HIGH;
    }

    /**
     * Validates successfully setting the outcome from an ID.
     */
    @Test
    void fromIdSuccess() {
        Outcome testOutcome = Outcome.fromId(2);
        assertEquals(Outcome.HIGH, testOutcome);
    }

    /**
     * Validates successfully getting ID.
     */
    @Test
    void getIdSuccess() {
        assertEquals(2, outcome.getId());
    }
}