package com.mattanderson.carbConscious.persistence;

import com.mattanderson.carbConscious.entity.*;
import com.mattanderson.carbConscious.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests database access for the <code>UserFavorite</code> class.
 * @author Matt Anderson
 * @version 11
 */
class UserFavoriteDaoTest {

    private GenericDao<UserFavorite> favoriteDao;
    private UserFavorite expectedFavorite;
    private UserFavorite newFavorite;
    private GenericDao<User> userDao;
    private MenuAPI api;
    private MenuItem item;
    private User user;
    private Restaurant restaurant;


    /**
     * Sets up the instance variables and cleans the database before each test.
     */
    @BeforeEach
    void setUp() {
        favoriteDao = new GenericDao<>(UserFavorite.class);
        userDao = new GenericDao<>(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        database.runSQL("insertData.sql");

        user = new User(1, "Matt", "Anderson", "mattanderson",
                "matt@gmail.com", "testing",
                LocalDateTime.of(2020,1,1,0,0),
                LocalDateTime.of(2020, 1, 2, 0, 0));

        api = new MenuAPI(1,"Spoonacular");
        restaurant = new Restaurant(1,"Pancake House", api, 3131);
        item = new MenuItem(1, "Blueberry Pancakes", "yummy pancakes", api, 22, restaurant);
        restaurant.addMenuItem(item);
        api.addRestaurant(restaurant);
        api.addMenuItem(item);
        expectedFavorite = new UserFavorite(1, 1,  user, item);
        user.addFavorite(expectedFavorite);
        newFavorite = new UserFavorite(23, user, item);
    }

    /**
     * Validates the get by id is successful.
     */
    @Test
    void getByIdSuccess() {
        UserFavorite actualUserFavorite = favoriteDao.getById(1);
        assertNotNull(actualUserFavorite);
        assertEquals(expectedFavorite, actualUserFavorite);

    }

    /**
     * Validates the get by property value is successful.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<UserFavorite> favorites = favoriteDao.getByPropertyEqual("id", "1");
        assertNotNull(favorites);
        for (UserFavorite fav : favorites) {
            assertEquals(expectedFavorite, fav);
        }
    }

    /**
     * Validates save or update is successful.
     */
    @Test
    void saveOrUpdateSuccess() {
        UserFavorite updatedUserFavorite = favoriteDao.getById(1);
        updatedUserFavorite.setLine(33);
        favoriteDao.saveOrUpdate(updatedUserFavorite);
        UserFavorite actualUserFavorite = favoriteDao.getById(1);
        assertNotNull(actualUserFavorite);
        assertEquals(updatedUserFavorite, actualUserFavorite);
    }

    /**
     * Validates insert is successful.
     */
    @Test
    void insertSuccess() {
        user.addFavorite(newFavorite);
        int insertId = favoriteDao.insert(newFavorite);
        newFavorite.setId(insertId);
        UserFavorite actualInsertUserFavorite = favoriteDao.getById(newFavorite.getId());
        assertNotNull(actualInsertUserFavorite);
        assertEquals(newFavorite, actualInsertUserFavorite);

    }

    /**
     * Validates delete is successful.
     */
    @Test
    void deleteSuccess() {
        favoriteDao.delete(favoriteDao.getById(1));
        assertNull(favoriteDao.getById(1));
    }

    /**
     * Validates that when a favorite is deleted, the user remains.
     */
    @Test
    void deleteFavoriteKeepUser() {
        UserFavorite favoriteTestDelete = favoriteDao.getById(1);
        User userTestKeep = favoriteTestDelete.getUser();
        favoriteDao.delete(favoriteTestDelete);
        assertNotNull(userDao.getById(userTestKeep.getId()));
    }

    /**
     * Validates the get all is successful.
     */
    @Test
    void getAllSuccess() {
        List<UserFavorite> allFavorites = favoriteDao.getAll();
        assertFalse(allFavorites.isEmpty());
        assertEquals(6, allFavorites.size());
    }
}