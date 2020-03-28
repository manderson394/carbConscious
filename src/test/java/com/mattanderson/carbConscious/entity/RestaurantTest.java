package com.mattanderson.carbConscious.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests the <code>Restaurant</code> class.
 * @author Matt Anderson
 * @version 11
 */
class RestaurantTest {

    private Restaurant restaurant;
    private MenuAPI api;
    private MenuItem item;
    private MenuItem newItem;
    private Restaurant newRestaurant;

    /**
     * Sets up instance variables before each test method.
     */
    @BeforeEach
    void setUp() {
        api = new MenuAPI(1, "Spoonacular");
        restaurant = new Restaurant(1, "Pancake House", api, 3131);
        item = new MenuItem(1, "Blueberry Pancakes", "yummy pancakes", api, 22, restaurant);
        restaurant.addMenuItem(item);
        api.addRestaurant(restaurant);
        api.addMenuItem(item);

        newItem = new MenuItem(2, "Waffles", "", api, 8383, restaurant);
        newRestaurant = new Restaurant(3, "IHOP", api, 2222);
    }

    /**
     * Validates creation of a restaurant with basic information.
     */
    @Test
    void createBasicRestaurantSuccess() {
        Restaurant basic = new Restaurant("Basic", api, 93);
        assertNotNull(basic);
    }

    /**
     * Validates successful creation of a restaurant with all information except for the ID.
     */
    @Test
    void createRestaurantWithoutIdSuccess() {
        Restaurant noId = new Restaurant("No ID", api, 93, new HashSet<MenuItem>(),
                LocalDateTime.of(2020, 3, 3, 3, 3));
        assertNotNull(noId);
    }

    /**
     * Validates successful creation of a restaurant with all infromation.
     */
    @Test
    void createRestaurantSuccess() {
        Restaurant all = new Restaurant(23, "All", api, 83, new HashSet<MenuItem>(),
                LocalDateTime.of(2011, 4,4,4,4));
        assertNotNull(all);
    }

    /**
     * Validates successful addition of a menu item.
     */
    @Test
    void addMenuItemSuccess() {
        restaurant.addMenuItem(newItem);
        assertTrue(restaurant.getMenuItems().contains(newItem));
    }

    /**
     * Validates successful menu item removal.
     */
    @Test
    void removeMenuItemSuccess() {
        restaurant.removeMenuItem(item);
        assertTrue(restaurant.getMenuItems().isEmpty());
    }

    /**
     * Validates successful string generation.
     */
    @Test
    void testToStringSuccess() {
        String expectedString = "Restaurant{id=" +
                restaurant.getId() + ", name=\'" +
                restaurant.getName() + "\', menuApi=" +
                restaurant.getMenuApi() + ", apiId=" +
                restaurant.getApiId() + ", creationDateTime=" +
                restaurant.getCreationDateTime() + "}";
        assertEquals(expectedString, restaurant.toString());
    }

    /**
     * Validates successful equality testing.
     */
    @Test
    void testEqualsSuccess() {
        assertEquals(restaurant, restaurant);
        assertNotEquals(restaurant, newRestaurant);
    }

    /**
     * Validates successful hash code generation.
     */
    @Test
    void testHashCode() {
        assertEquals(restaurant.hashCode(), restaurant.hashCode());
        assertNotEquals(restaurant.hashCode(), newRestaurant.hashCode());
    }

    /**
     * Validates id retrieval success.
     */
    @Test
    void getId() {
        assertEquals(1, restaurant.getId());
    }

    /**
     * Validates successful name retrieval.
     */
    @Test
    void getName() {
        assertEquals("Pancake House", restaurant.getName());
    }

    /**
     * Validates successful menu api retrieval.
     */
    @Test
    void getMenuApi() {
        assertEquals(api, restaurant.getMenuApi());
    }

    /**
     * Validates successful api id retrieval.
     */
    @Test
    void getApiId() {
        assertEquals(3131, restaurant.getApiId());
    }

    /**
     * Validates successful menu item retrieval.
     */
    @Test
    void getMenuItems() {
        Set<MenuItem> itemSet = new HashSet<>();
        itemSet.add(item);
        assertEquals(itemSet, restaurant.getMenuItems());
    }

    /**
     * Validates successful creation date time retrieval.
     */
    @Test
    void getCreationDateTime() {
        assertNull(restaurant.getCreationDateTime());
    }

    /**
     * Validates successfully setting id.
     */
    @Test
    void setId() {
        restaurant.setId(2);
        assertEquals(2, restaurant.getId());
    }

    /**
     * Validates successfully setting name.
     */
    @Test
    void setName() {
        restaurant.setName("Testing");
        assertEquals("Testing", restaurant.getName());
    }

    /**
     * Validates successfully setting menu api.
     */
    @Test
    void setMenuApi() {
        MenuAPI newApi = new MenuAPI("Tester");
        restaurant.setMenuApi(newApi);
        assertEquals(newApi, restaurant.getMenuApi());
    }

    /**
     * Validates successfully setting api id.
     */
    @Test
    void setApiId() {
        restaurant.setApiId(99);
        assertEquals(99, restaurant.getApiId());
    }

    /**
     * Validates successfully setting menu items.
     */
    @Test
    void setMenuItems() {
        Set<MenuItem> newItemSet = new HashSet<>();
        newItemSet.add(new MenuItem("Potatoes", "", api, 333, restaurant));
        restaurant.setMenuItems(newItemSet);
        assertEquals(newItemSet, restaurant.getMenuItems());
    }

    /**
     * Validates successfully setting creation date time.
     */
    @Test
    void setCreationDateTime() {
        LocalDateTime expectedDateTime = LocalDateTime.of(2010, 3, 3, 3, 3);
        restaurant.setCreationDateTime(expectedDateTime);
        assertEquals(expectedDateTime, restaurant.getCreationDateTime());
    }
}