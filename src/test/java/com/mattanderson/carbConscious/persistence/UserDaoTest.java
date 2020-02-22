package com.mattanderson.carbConscious.persistence;

import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests the <code>UserDao</code> class code.
 * @author Matt Anderson
 * @version 11
 */
class UserDaoTest {

    private UserDao dao;
    private User expectedUser;
    private GenericDao genericDao;

    /**
     * Sets up the instance variables and cleans the database before each test.
     */
    @BeforeEach
    void setUp() {
        dao = new UserDao();
        genericDao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        database.runSQL("insertData.sql");

        Set<String> expectedUserNames = new HashSet<>();
        expectedUserNames.add("mattanderson");

        expectedUser = new User(1, "Matt", "Anderson", expectedUserNames,
                "matt@gmail.com", "testing",
                LocalDateTime.of(2020,1,1,0,0),
                LocalDateTime.of(2020, 1, 2, 0, 0));
    }

    /**
     * Validates the get by id is successful.
     */
    @Test
    void getByIdSuccess() {
        User actualUser = (User)genericDao.getById(1);
        assertNotNull(actualUser);
        assertEquals(expectedUser, actualUser);

    }

    /**
     * Validates the get by property value is successful.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyEqual("userName", "mattanderson");
        assertNotNull(users);
        for (User user : users) {
            assertEquals(expectedUser, user);
        }
    }

    /**
     * Validates save or update is successful.
     */
    @Test
    void saveOrUpdateSuccess() {
        Set<String> saveOrUpdateUserNames = new HashSet<>();
        saveOrUpdateUserNames.add("mattanderson");
        User updatedUser = new User(1, "Matt", "Peterson", saveOrUpdateUserNames,
                "matt@gmail.com", "testing",
                LocalDateTime.of(2020,1,1,0,0),
                LocalDateTime.of(2020, 1, 2, 0, 0));
        dao.saveOrUpdate(updatedUser);
        User actualUser = dao.getById(1);
        assertNotNull(actualUser);
        assertEquals(updatedUser, actualUser);
    }

    /**
     * Validates insert is successful.
     */
    @Test
    void insertSuccess() {
        Set<String> insertUserNames = new HashSet<>();
        insertUserNames.add("mikeAnd23");
        User insertUser = new User( "Mike", "Anderson", insertUserNames, "mike@yahoo.com", "234(3L!",
                LocalDateTime.of(2020, 3, 23, 10, 53),
                LocalDateTime.of(2020, 4, 3, 11, 34));
        int insertId = dao.insert(insertUser);
        insertUser.setId(insertId);
        User actualInsertUser = dao.getById(insertId);
        assertNotNull(actualInsertUser);
        assertEquals(insertUser, actualInsertUser);

    }

    /**
     * Validates delete is successful.
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }
}