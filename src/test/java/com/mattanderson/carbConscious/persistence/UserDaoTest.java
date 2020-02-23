package com.mattanderson.carbConscious.persistence;

import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.entity.UserRole;
import com.mattanderson.carbConscious.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests database access for the <code>UserDao</code> class.
 * @author Matt Anderson
 * @version 11
 */
class UserDaoTest {

    private User expectedUser;
    private GenericDao dao;

    /**
     * Sets up the instance variables and cleans the database before each test.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        database.runSQL("insertData.sql");

        expectedUser = new User(1, "Matt", "Anderson", "mattanderson",
                "matt@gmail.com", "testing",
                LocalDateTime.of(2020,1,1,0,0),
                LocalDateTime.of(2020, 1, 2, 0, 0));
        UserRole expectedRole = new UserRole("User",
                LocalDateTime.of(2020,1,1,0,0), expectedUser);
        expectedUser.addRole(expectedRole);
    }

    /**
     * Validates the get by id is successful.
     */
    @Test
    void getByIdSuccess() {
        User actualUser = (User) dao.getById(1);
        assertNotNull(actualUser);
        assertEquals(expectedUser, actualUser);

    }

    /**
     * Validates the get by property value is successful.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = (List<User>) dao.getByPropertyEqual("userName", "mattanderson");
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
        User updatedUser = (User) dao.getById(1);
        updatedUser.setLastName("Peterson");
        dao.saveOrUpdate(updatedUser);
        User actualUser = (User) dao.getById(1);
        assertNotNull(actualUser);
        assertEquals(updatedUser, actualUser);
    }

    /**
     * Validates insert is successful.
     */
    @Test
    void insertSuccess() {
        User insertUser = new User( "Mike", "Anderson", "mikeAnd23", "mike@yahoo.com", "234(3L!",
                LocalDateTime.of(2020, 3, 23, 10, 53),
                LocalDateTime.of(2020, 4, 3, 11, 34));
        insertUser.addRole(new UserRole("User",
                LocalDateTime.of(2020,1,1,0,0), insertUser));
        int insertId = (int) dao.insert(insertUser);
        insertUser.setId(insertId);
        User actualInsertUser = (User) dao.getById(insertId);
        assertNotNull(actualInsertUser);
        assertEquals(insertUser, actualInsertUser);

    }

    /**
     * Validates delete is successful.
     */
    @Test
    void deleteSuccess() {
        dao.delete((User) dao.getById(1));
        assertNull(dao.getById(1));
    }

    /**
     * Validates the get by property like is successful.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("userName", "mattanderson");
        assertTrue(!users.isEmpty());
        User expectedUser = (User) dao.getById(1);
        assertEquals(expectedUser, users.get(0));
    }

    /**
     * Validates the get all is successful.
     */
    @Test
    void getAllSuccess() {
        List<User> allUsers = dao.getAll();
        assertTrue(!allUsers.isEmpty());
        assertEquals(5, allUsers.size());
    }
}