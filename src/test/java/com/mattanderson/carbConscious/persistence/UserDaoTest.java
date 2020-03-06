package com.mattanderson.carbConscious.persistence;

import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.entity.UserRole;
import com.mattanderson.carbConscious.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests database access for the <code>User</code> class.
 * @author Matt Anderson
 * @version 11
 */
class UserDaoTest {

    private User expectedUser;
    private GenericDao<User> dao;

    /**
     * Sets up the instance variables and cleans the database before each test.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao<>(User.class);
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
        User actualUser = dao.getById(1);
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
        User updatedUser = dao.getById(1);
        updatedUser.setLastName("Peterson");
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
        User insertUser = new User( "Mike", "Anderson", "mikeAnd23", "mike@yahoo.com", "234(3L!",
                LocalDateTime.of(2020, 3, 23, 10, 53, 3, 3),
                LocalDateTime.of(2020, 4, 3, 11, 34, 3, 3));
        insertUser.addRole(new UserRole("User",
                LocalDateTime.of(2020,1,1,0,0), insertUser));
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

    /**
     * Validates that when a user is deleted, the role is also deleted.
     */
    @Test
    void deleteUserDeleteRole() {
        User deleteUser = dao.getById(1);
        Set<UserRole> deleteRoles = deleteUser.getRoles();
        assertTrue(deleteRoles.size() > 0);
        dao.delete(deleteUser);
        GenericDao roleDao = new GenericDao(UserRole.class);
        for (UserRole role : deleteRoles) {
            assertNull(roleDao.getById(role.getId()));
        }
    }

    /**
     * Validates the get by property like is successful.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("userName", "mattanderson");
        assertFalse(users.isEmpty());
        User expectedUser = dao.getById(1);
        assertEquals(expectedUser, users.get(0));
    }

    /**
     * Validates the get all is successful.
     */
    @Test
    void getAllSuccess() {
        List<User> allUsers = dao.getAll();
        assertFalse(allUsers.isEmpty());
        assertEquals(5, allUsers.size());
    }
}