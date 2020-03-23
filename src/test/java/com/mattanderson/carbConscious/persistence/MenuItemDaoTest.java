package com.mattanderson.carbConscious.persistence;

import com.mattanderson.carbConscious.entity.*;
import com.mattanderson.carbConscious.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests database access for the <code>MenuItem</code> class.
 * @author Matt Anderson
 * @version 11
 */
class MenuItemDaoTest {

    private GenericDao<MenuItem> itemDao;
    private MenuAPI api;
    private MenuItem item;
    private User user;
    private UserFavorite favorite;
    private Restaurant restaurant;


    /**
     * Sets up the instance variables and cleans the database before each test.
     */
    @BeforeEach
    void setUp() {
        itemDao = new GenericDao<>(MenuItem.class);
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        database.runSQL("insertData.sql");

        user = new User(1, "Matt", "Anderson", "mattanderson",
                "matt@gmail.com", "testing",
                LocalDateTime.of(2020,1,1,0,0),
                LocalDateTime.of(2020, 1, 2, 0, 0));

        api = new MenuAPI(1,"Spoonacular");
        restaurant = new Restaurant(1,"Pancake House", api, 3131);
        item = new MenuItem(1, "Blueberry Pancakes", api, 22, restaurant);
        restaurant.addMenuItem(item);
        api.addRestaurant(restaurant);
        api.addMenuItem(item);

        favorite = new UserFavorite(1, user, item);
        user.addFavorite(favorite);
    }

    /**
     * Validates the get by id is successful.
     */
    @Test
    void getByIdSuccess() {
        MenuItem actualItem = itemDao.getById(1);
        assertNotNull(actualItem);
        assertEquals(item, actualItem);

    }

    /**
     * Validates the get by property value is successful.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<MenuItem> items = itemDao.getByPropertyEqual("id", "1");
        assertNotNull(items);
        for (MenuItem menuItem : items) {
            assertEquals(item, menuItem);
        }
    }

    /**
     * Validates save or update is successful.
     */
    @Test
    void saveOrUpdateSuccess() {
        MenuItem updatedMenuItem = itemDao.getById(1);
        updatedMenuItem.setApiId(939);
        itemDao.saveOrUpdate(updatedMenuItem);
        MenuItem actualMeuItem = itemDao.getById(1);
        assertNotNull(actualMeuItem);
        assertEquals(updatedMenuItem, actualMeuItem);
    }

    /**
     * Validates insert is successful.
     */
    @Test
    void insertSuccess() {
        MenuItem newItem = new MenuItem ("Egg Drop Soup", api, 8998, restaurant);
        restaurant.addMenuItem(newItem);
        api.addMenuItem(newItem);
        int insertId = itemDao.insert(newItem);
        newItem.setId(insertId);
        MenuItem actualInsertMenuItem = itemDao.getById(newItem.getId());
        assertNotNull(actualInsertMenuItem);
        assertEquals(newItem, actualInsertMenuItem);

    }

    /**
     * Validates delete is successful.
     */
    @Test
    void deleteSuccess() {
        itemDao.delete(itemDao.getById(1));
        assertNull(itemDao.getById(1));
    }

    /**
     * Validates that when a menu item is deleted, the user favorite is also deleted.
     */
    @Test
    void deleteMenuItemDeleteFavorite() {
        MenuItem itemTestDelete = itemDao.getById(1);
        GenericDao<UserFavorite> favoriteDao = new GenericDao<>(UserFavorite.class);
        List<UserFavorite> favoritesTestDelete = favoriteDao.getByPropertyEqual("menuItem", itemTestDelete);
        assertTrue(favoritesTestDelete.size() > 0);
        itemDao.delete(itemTestDelete);
        assertTrue(favoriteDao.getByPropertyEqual("menuItem", itemTestDelete).isEmpty());
    }

    /**
     * Validates that when a menu item is deleted, the api remains.
     */
    @Test
    void deleteMenuItemKeepApi() {
        MenuItem itemDeleteTest = itemDao.getById(1);
        GenericDao<MenuAPI> apiDao = new GenericDao<>(MenuAPI.class);
        itemDao.delete(itemDeleteTest);
        assertNotNull(apiDao.getById(1));
    }

    /**
     * Validates that when a menu item is deleted, the restaurant remains.
     */
    @Test
    void deleteMenuItemKeepRestaurant() {
        MenuItem itemDeleteTest = itemDao.getById(1);
        GenericDao<Restaurant> restaurantDao = new GenericDao<>(Restaurant.class);
        itemDao.delete(itemDeleteTest);
        assertNotNull(restaurantDao.getById(1));

    }

    /**
     * Validates the get all is successful.
     */
    @Test
    void getAllSuccess() {
        List<MenuItem> allItems = itemDao.getAll();
        assertFalse(allItems.isEmpty());
        assertEquals(5, allItems.size());
    }
}