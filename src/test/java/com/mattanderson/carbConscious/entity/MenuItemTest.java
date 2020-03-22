package com.mattanderson.carbConscious.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests the <code>MenuItem</code> class.
 * @author Matt Anderson
 * @version 11
 */
class MenuItemTest {

    private MenuAPI api;
    private MenuItem item;
    private User user;
    private Restaurant restaurant;
    private CarbohydratesEstimate estimate;
    private CarbohydratesEstimate newEstimate;


    /**
     * Sets up the instance variables and cleans the database before each test.
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
        restaurant.addMenuItem(item);
        api.addRestaurant(restaurant);
        api.addMenuItem(item);
        item.addCarbohydratesEstimate(estimate);
        item.setCreationDateTime(LocalDateTime.of(2020, 3, 14, 0, 0, 0));

        newEstimate = new CarbohydratesEstimate(23, 333, item, Outcome.fromId(2), user);
    }

    /**
     * Validates successful creation of a menu item object given basic information but no ID.
     */
    @Test
    void createMenuItemBasicNoId() {
        MenuItem newItem = new MenuItem("Test", api, 23, restaurant);
        assertNotNull(newItem);
    }

    /**
     * Validates successful creation of a menu item object with all instance variables except for ID.
     */
    @Test
    void createMenuItemNoId() {
        MenuItem allNoId = new MenuItem("food", api, 33333, restaurant, new HashSet<CarbohydratesEstimate>(),
                LocalDateTime.of(2020, 2, 2, 2, 2));
        assertNotNull(allNoId);
    }

    /**
     * Validates successful creation of a menu item object with all instance variables.
     */
    @Test
    void createMenuItemAll(){
        MenuItem all = new MenuItem(83, "foods", api, 83838, restaurant, new HashSet<CarbohydratesEstimate>(),
                LocalDateTime.of(1999, 9, 9, 9, 9));
        assertNotNull(all);
    }

    /**
     * Validates successful addition of carbohydrate estimates to a menu item.
     */
    @Test
    void addCarbohydratesEstimateSuccess() {
        item.addCarbohydratesEstimate(newEstimate);
        assertEquals(2, item.getCarbohydratesEstimates().size());
        assertTrue(item.getCarbohydratesEstimates().contains(newEstimate));
    }

    /**
     * Validates successful removal of carbohydrate estimates from a menu item.
     */
    @Test
    void removeCarbohydratesEstimateSuccess() {
        item.removeCarbohydratesEstimate(estimate);
        assertEquals(0, item.getCarbohydratesEstimates().size());
    }

    /**
     * Validates successful generation of string representation for the menu item.
     */
    @Test
    void testToStringSuccess() {
        String expectedString = "MenuItem{id=" +
                item.getId() + ", name=\'" +
                item.getName() + "\', menuApi=" +
                item.getMenuApi() + ", apiId=" +
                item.getApiId() + ", parentRestaurant=" +
                item.getParentRestaurant() + ", creationDateTime=" +
                item.getCreationDateTime() + "}";
        assertEquals(expectedString, item.toString());
    }

    /**
     * Validates successful equality comparison.
     */
    @Test
    void testEqualsSuccess() {
        MenuItem newItem = new MenuItem(23, "Some Food!", api, 33, restaurant);
        assertEquals(item, item);
        assertNotEquals(newItem, item);
    }

    /**
     * Validates successful hash code generation.
     */
    @Test
    void testHashCodeSuccess() {
        MenuItem newItem = new MenuItem("More Food", api, 33);
        assertEquals(item.hashCode(), item.hashCode());
        assertNotEquals(newItem.hashCode(), item.hashCode());
    }

    /**
     * Validates successful id retrieval.
     */
    @Test
    void getIdSuccess() {
        assertEquals(1, item.getId());
    }

    /**
     * Validates successful name retrieval.
     */
    @Test
    void getNameSuccess() {
        assertEquals("Blueberry Pancakes", item.getName());
    }

    /**
     * Validates successful api retrieval.
     */
    @Test
    void getMenuApiSuccess() {
        assertEquals(api, item.getMenuApi());
    }

    /**
     * Validates successful api id retrieval.
     */
    @Test
    void getApiIdSuccess() {
        assertEquals(22, item.getApiId());
    }

    /**
     * Validates successful parent restaurant retrieval.
     */
    @Test
    void getParentRestaurantSuccess() {
        assertEquals(restaurant, item.getParentRestaurant());
    }

    /**
     * Validates successful carbohydrate estimate retrieval.
     */
    @Test
    void getCarbohydratesEstimatesSuccess() {
        Set<CarbohydratesEstimate> estimatesSet = new HashSet<>();
        estimatesSet.add(estimate);
        assertEquals(estimatesSet, item.getCarbohydratesEstimates());
    }

    /**
     * Validates successful creation time retreival.
     */
    @Test
    void getCreationDateTimeSuccess() {
        assertEquals(LocalDateTime.of(2020, 3, 14, 0, 0, 0), item.getCreationDateTime());
    }

    /**
     * Validates successfully setting id.
     */
    @Test
    void setIdSuccess() {
        item.setId(2);
        assertEquals(2, item.getId());
    }

    /**
     * Validates successfully setting name.
     */
    @Test
    void setNameSuccess() {
        item.setName("Something");
        assertEquals("Something", item.getName());
    }

    /**
     * Validates successfully setting menu api.
     */
    @Test
    void setMenuApiSuccess() {
        MenuAPI newApi = new MenuAPI("Test");
        item.setMenuApi(newApi);
        assertEquals(newApi, item.getMenuApi());
    }

    /**
     * Validates successfully setting api id.
     */
    @Test
    void setApiIdSuccess() {
        item.setApiId(333);
        assertEquals(333, item.getApiId());
    }

    /**
     * Validates successfully setting parent restaurant.
     */
    @Test
    void setParentRestaurantSuccess() {
        Restaurant newRestaurant = new Restaurant("Joe's", api, 3333333);
        item.setParentRestaurant(newRestaurant);
        assertEquals(newRestaurant, item.getParentRestaurant());
    }

    /**
     * Validates successfully setting carbohydrate estimates.
     */
    @Test
    void setCarbohydratesEstimatesSuccess() {
        HashSet<CarbohydratesEstimate> newEstimates = new HashSet<>();
        newEstimates.add(new CarbohydratesEstimate(33, item, Outcome.fromId(0), user));
        item.setCarbohydratesEstimates(newEstimates);
        assertEquals(newEstimates, item.getCarbohydratesEstimates());
    }

    /**
     * Validates successfully setting creation time.
     */
    @Test
    void setCreationDateTimeSuccess() {
        LocalDateTime newCreateDateTime = LocalDateTime.of(2020, 3, 30, 3, 3);
        item.setCreationDateTime(newCreateDateTime);
        assertEquals(newCreateDateTime, item.getCreationDateTime());
    }
}