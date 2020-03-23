package com.mattanderson.carbConscious.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests the <code>CarbohydratesEstimate</code> class.
 * @author Matt Anderson
 * @version 11
 */
class CarbohydratesEstimateTest {

    private CarbohydratesEstimate estimate;
    private User user;
    private MenuItem item;
    private Restaurant restaurant;
    private MenuAPI api;
    private CarbohydratesEstimate newEstimate;
    private LocalDateTime dateTime;

    /**
     * Sets up instance variables before each unit test.
     */
    @BeforeEach
    void setUp() {

        user = new User(1, "Matt", "Anderson", "mattanderson",
                "matt@gmail.com", "testing",
                LocalDateTime.of(2020, 1, 1, 0, 0),
                LocalDateTime.of(2020, 1, 2, 0, 0));

        api = new MenuAPI(1, "Spoonacular");
        restaurant = new Restaurant(1, "Pancake House", api, 3131);
        item = new MenuItem(1, "Blueberry Pancakes", api, 22, restaurant);

        estimate = new CarbohydratesEstimate(1, 75, item, Outcome.fromId(1), user);
        newEstimate = new CarbohydratesEstimate(80, item, Outcome.fromId(2), user);

        dateTime = LocalDateTime.of(1999, 9, 9, 9, 9, 9);
    }

    /**
     * Validates successful carbohydrate estimate creation with all but the id information.
     */
    @Test
    void createEstimateNoId() {
        CarbohydratesEstimate noId = new CarbohydratesEstimate(75, item, Outcome.fromId(0), user,
                LocalDateTime.of(2020, 2, 2, 2, 2),
                LocalDateTime.of(2020, 2, 2, 2, 2));
        assertNotNull(noId);
    }

    /**
     * Validates successful carbohydrate estimate creation with all information.
     */
    @Test
    void createEstimateAll() {
        CarbohydratesEstimate all = new CarbohydratesEstimate(45,75, item, Outcome.fromId(0), user,
                LocalDateTime.of(2020, 2, 2, 2, 2),
                LocalDateTime.of(2020, 2, 2, 2, 2));
        assertNotNull(all);
    }

    /**
     * Validate successful equality evaluation.
     */
    @Test
    void testEqualsSuccess() {
        assertEquals(estimate, estimate);
        assertNotEquals(estimate, newEstimate);
    }

    /**
     * Validates successful hash code generation.
     */
    @Test
    void testHashCodeSuccess() {
        assertEquals(estimate.hashCode(), estimate.hashCode());
        assertNotEquals(estimate.hashCode(), newEstimate.hashCode());
    }

    /**
     * Validates successfully getting id.
     */
    @Test
    void getIdSuccess() {
        assertEquals(1, estimate.getId());
    }

    /**
     * Validates successfully getting carbohydrate gram estimate.
     */
    @Test
    void getCarbohydrateGramsEstimateSuccess() {
        assertEquals(75, estimate.getCarbohydrateGramsEstimate());
    }

    /**
     * Validates successfully getting menu item.
     */
    @Test
    void getMenuItemSuccess() {
        assertEquals(item, estimate.getMenuItem());
    }

    /**
     * Validates successfully getting outcome.
     */
    @Test
    void getOutcomeSuccess() {
        assertEquals(Outcome.IN_RANGE, estimate.getOutcome());
    }

    /**
     * Validates successfully getting user.
     */
    @Test
    void getUserSuccess() {
        assertEquals(user, estimate.getUser());
    }

    /**
     * Validates successfully getting creation date time.
     */
    @Test
    void getCreationDateTimeSuccess() {
        estimate.setCreationDateTime(dateTime);
        assertEquals(dateTime, estimate.getCreationDateTime());
    }

    /**
     * Validates successfully getting update date time.
     */
    @Test
    void getUpdateDateTimeSuccess() {
        estimate.setUpdateDateTime(dateTime);
        assertEquals(dateTime, estimate.getUpdateDateTime());
    }

    /**
     * Validates successfully setting id.
     */
    @Test
    void setIdSuccess() {
        estimate.setId(23);
        assertEquals(23, estimate.getId());
    }

    /**
     * Validates successfully setting carbohydrate gram estimate.
     */
    @Test
    void setCarbohydrateGramsEstimateSuccess() {
        estimate.setCarbohydrateGramsEstimate(90);
        assertEquals(90, estimate.getCarbohydrateGramsEstimate());
    }

    /**
     * Validates successfully setting menu item.
     */
    @Test
    void setMenuItemSuccess() {
        MenuItem newItem = new MenuItem("Food", api, 90);
        estimate.setMenuItem(newItem);
        assertEquals(newItem, estimate.getMenuItem());
    }

    /**
     * Validates successfully setting outcome.
     */
    @Test
    void setOutcomeSuccess() {
        estimate.setOutcome(Outcome.fromId(2));
        assertEquals(Outcome.HIGH, estimate.getOutcome());
    }

    /**
     * Validates successfully setting user.
     */
    @Test
    void setUserSuccess() {
        User newUser = new User("Joe", "Smith", "jsmith", "jsmith@yahoo.com", "heythere");
        estimate.setUser(newUser);
        assertEquals(newUser, estimate.getUser());
    }

    /**
     * Validates successfully setting creation date time.
     */
    @Test
    void setCreationDateTimeSuccess() {
        estimate.setCreationDateTime(dateTime);
        assertEquals(dateTime, estimate.getCreationDateTime());
    }

    /**
     * Validates successful update date time setting.
     */
    @Test
    void setUpdateDateTimeSuccess() {
        estimate.setUpdateDateTime(dateTime);
        assertEquals(dateTime, estimate.getUpdateDateTime());
    }

    /**
     * Validates successful string creation.
     */
    @Test
    void testToStringSuccess() {
        String expectedString = "CarbohydratesEstimate(id=" +
                estimate.getId() + ", carbohydrateGramsEstimate=" +
                estimate.getCarbohydrateGramsEstimate() + ", menuItem=" +
                estimate.getMenuItem() + ", outcome=" +
                estimate.getOutcome() + ", user=" +
                estimate.getUser() + ", creationDateTime=" +
                estimate.getCreationDateTime() + ", updateDateTime=" +
                estimate.getUpdateDateTime() + ")";
        assertEquals(expectedString, estimate.toString());
    }
}