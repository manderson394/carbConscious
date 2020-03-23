package com.mattanderson.carbConscious.persistence;

import com.mattanderson.carbConscious.entity.MenuAPI;
import com.mattanderson.carbConscious.entity.MenuItem;
import com.mattanderson.carbConscious.entity.Restaurant;
import com.mattanderson.carbConscious.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests database access for the <code>MenuAPI</code> class.
 * @author Matt Anderson
 * @version 11
 */
class MenuAPIDaoTest {

    private GenericDao<MenuAPI> apiDao;
    private MenuAPI api;
    private MenuItem item;
    private Restaurant restaurant;


    /**
     * Sets up the instance variables and cleans the database before each test.
     */
    @BeforeEach
    void setUp() {
        apiDao = new GenericDao<>(MenuAPI.class);
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        database.runSQL("insertData.sql");

        api = new MenuAPI(1,"Spoonacular");
        restaurant = new Restaurant(1,"Pancake House", api, 3131);
        item = new MenuItem(1, "Blueberry Pancakes", api, 22, restaurant);
        restaurant.addMenuItem(item);
        api.addRestaurant(restaurant);
        api.addMenuItem(item);
    }

    /**
     * Validates the get by id is successful.
     */
    @Test
    void getByIdSuccess() {
        MenuAPI actualApi = apiDao.getById(1);
        assertNotNull(actualApi);
        assertEquals(api, actualApi);

    }

    /**
     * Validates the get by property value is successful.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<MenuAPI> apis = apiDao.getByPropertyEqual("id", "1");
        assertNotNull(apis);
        for (MenuAPI apiObj : apis) {
            assertEquals(api, apiObj);
        }
    }

    /**
     * Validates save or update is successful.
     */
    @Test
    void saveOrUpdateSuccess() {
        MenuAPI updatedApi = apiDao.getById(1);
        updatedApi.setName("Round 2");
        apiDao.saveOrUpdate(updatedApi);
        MenuAPI actualApi = apiDao.getById(1);
        assertNotNull(actualApi);
        assertEquals(updatedApi, actualApi);
    }

    /**
     * Validates insert is successful.
     */
    @Test
    void insertSuccess() {
        MenuAPI newApi = new MenuAPI ("Newbie");
        int insertId = apiDao.insert(newApi);
        newApi.setId(insertId);
        MenuAPI actualInsertApi = apiDao.getById(newApi.getId());
        assertNotNull(actualInsertApi);
        assertEquals(newApi, actualInsertApi);

    }

    /**
     * Validates delete is successful.
     */
    @Test
    void deleteSuccess() {
        apiDao.delete(apiDao.getById(1));
        assertNull(apiDao.getById(1));
    }

    /**
     * Validates that when a menu API is deleted, the menu item is kept.
     */
    @Test
    void deleteApitKeepMenuItem() {
        MenuAPI apiTestDelete = apiDao.getById(1);
        GenericDao<MenuItem> menuItemDao = new GenericDao<>(MenuItem.class);
        List<MenuItem> menuItemsTestDelete = menuItemDao.getByPropertyEqual("menuApi", apiTestDelete);
        assertTrue(menuItemsTestDelete.size() > 0);
        apiDao.delete(apiTestDelete);
        for (MenuItem testItems : menuItemsTestDelete) {
            assertNotNull(menuItemDao.getById(testItems.getId()));
        }
    }

    /**
     * Validates that when a menu API is deleted, the restaurant remains.
     */
    @Test
    void deleteApiKeepRestaurant() {
        MenuAPI apiTestDelete = apiDao.getById(1);
        GenericDao<Restaurant> restaurantDao = new GenericDao<>(Restaurant.class);
        List<Restaurant> restaurantsTestDelete = restaurantDao.getByPropertyEqual("menuApi", apiTestDelete);
        assertTrue(restaurantsTestDelete.size() > 0);
        apiDao.delete(apiTestDelete);
        for (Restaurant testRestaurants : restaurantsTestDelete) {
            assertNotNull(restaurantDao.getById(testRestaurants.getId()));
        }
    }

    /**
     * Validates the get all is successful.
     */
    @Test
    void getAllSuccess() {
        List<MenuAPI> allApis = apiDao.getAll();
        assertFalse(allApis.isEmpty());
        assertEquals(2, allApis.size());
    }
}