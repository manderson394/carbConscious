package com.mattanderson.carbConscious.persistence;

import com.mattanderson.carbConscious.entity.*;
import com.mattanderson.carbConscious.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests database access for the <code>CarbohydratesEstimate</code> class.
 * @author Matt Anderson
 * @version 11
 */
class CarbohydratesEstimateDaoTest {

    private GenericDao<CarbohydratesEstimate> estimateDao;
    private MenuAPI api;
    private MenuItem item;
    private User user;
    private Restaurant restaurant;
    private CarbohydratesEstimate estimate;


    /**
     * Sets up the instance variables and cleans the database before each test.
     */
    @BeforeEach
    void setUp() {
        estimateDao = new GenericDao<>(CarbohydratesEstimate.class);
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

        estimate = new CarbohydratesEstimate(1, 75, item, Outcome.fromId(1), user);
        item.addCarbohydratesEstimate(estimate);
    }

    /**
     * Validates the get by id is successful.
     */
    @Test
    void getByIdSuccess() {
        CarbohydratesEstimate actualEstimate = estimateDao.getById(1);
        assertNotNull(actualEstimate);
        assertEquals(estimate, actualEstimate);

    }

    /**
     * Validates the get by property value is successful.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<CarbohydratesEstimate> estimates = estimateDao.getByPropertyEqual("id", "1");
        assertNotNull(estimates);
        for (CarbohydratesEstimate carbEstimate : estimates) {
            assertEquals(estimate, carbEstimate);
        }
    }

    /**
     * Validates save or update is successful.
     */
    @Test
    void saveOrUpdateSuccess() {
        CarbohydratesEstimate updatedEstimate = estimateDao.getById(1);
        updatedEstimate.setCarbohydrateGramsEstimate(99);
        estimateDao.saveOrUpdate(updatedEstimate);
        CarbohydratesEstimate actualEstimate = estimateDao.getById(1);
        assertNotNull(actualEstimate);
        assertEquals(updatedEstimate, actualEstimate);
    }

    /**
     * Validates insert is successful.
     */
    @Test
    void insertSuccess() {
        CarbohydratesEstimate newEstimate = new CarbohydratesEstimate (100, item, Outcome.fromId(0), user);
        item.addCarbohydratesEstimate(newEstimate);
        int insertId = estimateDao.insert(newEstimate);
        newEstimate.setId(insertId);
        CarbohydratesEstimate actualInsertEstimate = estimateDao.getById(newEstimate.getId());
        assertNotNull(actualInsertEstimate);
        assertEquals(newEstimate, actualInsertEstimate);

    }

    /**
     * Validates delete is successful.
     */
    @Test
    void deleteSuccess() {
        estimateDao.delete(estimateDao.getById(1));
        assertNull(estimateDao.getById(1));
    }

    /**
     * Validates the get all is successful.
     */
    @Test
    void getAllSuccess() {
        List<CarbohydratesEstimate> allEstimates = estimateDao.getAll();
        assertFalse(allEstimates.isEmpty());
        assertEquals(6, allEstimates.size());
    }
}