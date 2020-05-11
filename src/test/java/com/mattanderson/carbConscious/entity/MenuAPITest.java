package com.mattanderson.carbConscious.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests the <code>MenuAPI</code> class.
 * @author Matt Anderson
 * @version 11
 */
class MenuAPITest {

    private MenuAPI api;
    private MenuAPI newApi;
    private Restaurant restaurant;
    private MenuItem item;
    private Set<Restaurant> restaurants;
    private Set<MenuItem> items;


    /**
     * Sets up instance variables before each unit test.
     */
    @BeforeEach
    void setUp() {
        api = new MenuAPI(1,"Spoonacular");
        restaurant = new Restaurant(1,"Pancake House", api, 3131);
        item = new MenuItem(1, "Blueberry Pancakes", "yummy pancakes", api, 22, restaurant);
        restaurant.addMenuItem(item);
        api.addRestaurant(restaurant);
        api.addMenuItem(item);

        restaurants = new HashSet<>();
        restaurants.add(restaurant);

        items = new HashSet<>();
        items.add(item);

        newApi = new MenuAPI(34, "NewAPI");

    }

    /**
     * Validates menu api creation with the most basic information, the name only.
     */
    @Test
    void createMenuApiBasic() {
        MenuAPI basic = new MenuAPI("Test");
        assertNotNull(basic);
    }


    /**
     * Validates menu api creation with all but the id known.
     */
    @Test
    void createMenuApiNoId() {
        MenuAPI noId = new MenuAPI("Test", new HashSet<Restaurant>(), new HashSet<MenuItem>(),
                LocalDateTime.of(1999, 9, 9,9, 9 ));
        assertNotNull(noId);
    }

    /**
     * Validates menu api creation with all information known.
     */
    @Test
    void createMenuApiAll() {
        MenuAPI all = new MenuAPI(1, "Test", new HashSet<Restaurant>(), new HashSet<MenuItem>(),
                LocalDateTime.of(1999, 9, 9,9, 9 ));
        assertNotNull(all);
    }

    /**
     * Validates successful restaurant addition.
     */
    @Test
    void addRestaurantSuccess() {
        Restaurant newRestaurant = new Restaurant("MyRestaurant", api, 623);
        api.addRestaurant(newRestaurant);
        assertTrue(api.getRestaurants().contains(newRestaurant));
    }

    /**
     * Validates successful restaurant removal.
     */
    @Test
    void removeRestaurantSuccess() {
        api.removeRestaurant(restaurant);
        assertFalse(api.getRestaurants().contains(restaurant));
    }

    /**
     * Validates successful menu item addition.
     */
    @Test
    void addMenuItemSuccess() {
        MenuItem newItem = new MenuItem("NewItem", "", api, 8343);
        api.addMenuItem(newItem);
        assertTrue(api.getMenuItems().contains(newItem));
    }

    /**
     * Validates successful menu item removal.
     */
    @Test
    void removeMenuItemSuccess() {
        api.removeMenuItem(item);
        assertFalse(api.getMenuItems().contains(item));
    }

    /**
     * Validates successful string creation.
     */
    @Test
    void testToStringSuccess() {
        String expectedString = "MenuAPI{id=" +
                api.getId() + ", name=\'" +
                api.getName() + "\'}";
        assertEquals(expectedString, api.toString());
    }

    /**
     * Validates successful equality evaluation.
     */
    @Test
    void testEqualsSuccess() {
        assertEquals(api, api);
        assertNotEquals(api, newApi);
    }

    /**
     * Validates successful hash code creation.
     */
    @Test
    void testHashCodeSuccess() {
        assertEquals(api.hashCode(), api.hashCode());
        assertNotEquals(api.hashCode(), newApi.hashCode());
    }

    /**
     * Validates successfully getting ID.
     */
    @Test
    void getIdSuccess() {
        assertEquals(1, api.getId());
    }

    /**
     * Validates successfully getting name.
     */
    @Test
    void getNameSuccess() {
        assertEquals("Spoonacular", api.getName());
    }

    /**
     * Validates successfully getting restaurants.
     */
    @Test
    void getRestaurantsSuccess() {
        assertEquals(restaurants, api.getRestaurants());
    }

    /**
     * Validates successfully getting menu items.
     */
    @Test
    void getMenuItemsSuccess() {
        assertEquals(items, api.getMenuItems());
    }

    /**
     * Validates successfully getting creation date time.
     */
    @Test
    void getCreationDateTimeSuccess() {
        LocalDateTime dateTime = LocalDateTime.of(2020, 2, 2, 2,2, 2);
        api.setCreationDateTime(dateTime);
        assertEquals(dateTime, api.getCreationDateTime());
    }

    /**
     * Validates successfully setting ID.
     */
    @Test
    void setIdSuccess() {
        api.setId(23);
        assertEquals(23, api.getId());
    }

    /**
     * Validates successfully setting name.
     */
    @Test
    void setNameSuccess() {
        api.setName("Woo");
        assertEquals("Woo", api.getName());
    }

    /**
     * Validates successfully setting restaurants.
     */
    @Test
    void setRestaurantsSuccess() {
        restaurants.add(new Restaurant("Your Place", api, 2383));
        api.setRestaurants(restaurants);
        assertEquals(restaurants, api.getRestaurants());
    }

    /**
     * Validates successfully setting menu items.
     */
    @Test
    void setMenuItemsSuccess() {
        items.add(new MenuItem("Duck", "", api, 8392));
        api.setMenuItems(items);
        assertEquals(items, api.getMenuItems());
    }

    /**
     * Validates successfully setting creation date time.
     */
    @Test
    void setCreationDateTimeSuccess() {
        LocalDateTime newDateTime = LocalDateTime.of(2020, 4, 4, 4, 4);
        api.setCreationDateTime(newDateTime);
        assertEquals(newDateTime, api.getCreationDateTime());
    }
}