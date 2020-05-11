package com.mattanderson.carbConscious.persistence;

import com.mattanderson.carbConscious.entity.*;
import com.mattanderson.carbConscious.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests database access for the <code>Restaurant</code> class.
 * @author Matt Anderson
 * @version 11
 */
class RestaurantDaoTest {

    private GenericDao<Restaurant> restaurantDao;
    private MenuAPI api;
    private MenuItem item;
    private Restaurant restaurant;


    /**
     * Sets up the instance variables and cleans the database before each test.
     */
    @BeforeEach
    void setUp() {
        restaurantDao = new GenericDao<>(Restaurant.class);
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        database.runSQL("insertData.sql");

        api = new MenuAPI(1,"Spoonacular");
        restaurant = new Restaurant(1,"Pancake House", "123 Street", "WI", "55555", "608-608-6088", api, 3131);
        item = new MenuItem(1, "Blueberry Pancakes", "yummy pancakes", api, 22, restaurant);
        restaurant.addMenuItem(item);
        api.addRestaurant(restaurant);
        api.addMenuItem(item);
    }

    /**
     * Validates the get by id is successful.
     */
    @Test
    void getByIdSuccess() {
        Restaurant actualRestaurant = restaurantDao.getById(1);
        assertNotNull(actualRestaurant);
        assertEquals(restaurant, actualRestaurant);

    }

    /**
     * Validates the get by property value is successful.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Restaurant> restaurants = restaurantDao.getByPropertyEqual("id", "1");
        assertNotNull(restaurants);
        for (Restaurant restaurantObj : restaurants) {
            assertEquals(restaurant, restaurantObj);
        }
    }

    /**
     * Validates save or update is successful.
     */
    @Test
    void saveOrUpdateSuccess() {
        Restaurant updatedRestaurant = restaurantDao.getById(1);
        updatedRestaurant.setApiId(939);
        restaurantDao.saveOrUpdate(updatedRestaurant);
        Restaurant actualRestaurant = restaurantDao.getById(1);
        assertNotNull(actualRestaurant);
        assertEquals(updatedRestaurant, actualRestaurant);
    }

    /**
     * Validates insert is successful.
     */
    @Test
    void insertSuccess() {
        Restaurant newRestaurant = new Restaurant("New Pancake House", "124 Street", "WI", "55555", "608-608-6089", api, 3231);
        api.addRestaurant(newRestaurant);
        int insertId = restaurantDao.insert(newRestaurant);
        newRestaurant.setId(insertId);
        Restaurant actualInsertRestaurant = restaurantDao.getById(newRestaurant.getId());
        assertNotNull(actualInsertRestaurant);
        assertEquals(newRestaurant, actualInsertRestaurant);

    }

    /**
     * Validates delete is successful.
     */
    @Test
    void deleteSuccess() {
        restaurantDao.delete(restaurantDao.getById(1));
        assertNull(restaurantDao.getById(1));
    }

    /**
     * Validates that when a restaurant is deleted, the menu item is kept.
     */
    @Test
    void deleteRestaurantKeepMenuItem() {
        Restaurant restaurantTestDelete = restaurantDao.getById(1);
        GenericDao<MenuItem> menuItemDao = new GenericDao<>(MenuItem.class);
        List<MenuItem> menuItemsTestDelete = menuItemDao.getByPropertyEqual("parentRestaurant", restaurantTestDelete);
        assertTrue(menuItemsTestDelete.size() > 0);
        restaurantDao.delete(restaurantTestDelete);
        for (MenuItem testItems : menuItemsTestDelete) {
            assertNotNull(menuItemDao.getById(testItems.getId()));
        }
    }

    /**
     * Validates that when a restaurant is deleted, the api remains.
     */
    @Test
    void deleteRestaurantKeepApi() {
        Restaurant restaurantDeleteTest = restaurantDao.getById(1);
        GenericDao<MenuAPI> apiDao = new GenericDao<>(MenuAPI.class);
        restaurantDao.delete(restaurantDeleteTest);
        assertNotNull(apiDao.getById(1));
    }

    /**
     * Validates the get all is successful.
     */
    @Test
    void getAllSuccess() {
        List<Restaurant> allRestaurants = restaurantDao.getAll();
        assertFalse(allRestaurants.isEmpty());
        assertEquals(3, allRestaurants.size());
    }
}