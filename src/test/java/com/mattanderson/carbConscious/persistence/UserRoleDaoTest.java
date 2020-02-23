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
 * Unit tests database access for the <code>UserRole</code> class.
 * @author Matt Anderson
 * @version 11
 */
class UserRoleDaoTest {

    private User expectedUser;
    private GenericDao dao;
    private UserRole expectedRole;

    /**
     * Sets up the instance variables and cleans the database before each test.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(UserRole.class);
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        database.runSQL("insertData.sql");

        expectedUser = new User(1, "Matt", "Anderson", "mattanderson",
                "matt@gmail.com", "testing",
                LocalDateTime.of(2020,1,1,0,0),
                LocalDateTime.of(2020, 1, 2, 0, 0));
        expectedRole = new UserRole(1,"User",
                LocalDateTime.of(2020,1,1,0,0), expectedUser);
        expectedUser.addRole(expectedRole);
    }

    /**
     * Validates the get by id is successful.
     */
    @Test
    void getByIdSuccess() {
        UserRole actualUserRole = (UserRole) dao.getById(1);
        assertNotNull(actualUserRole);
        assertEquals(expectedRole, actualUserRole);

    }

    /**
     * Validates the get by property value is successful.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<UserRole> roles = (List<UserRole>) dao.getByPropertyEqual("id", "1");
        assertNotNull(roles);
        for (UserRole role : roles) {
            assertEquals(expectedRole, role);
        }
    }

    /**
     * Validates save or update is successful.
     */
    @Test
    void saveOrUpdateSuccess() {
        UserRole updatedUserRole = (UserRole) dao.getById(1);
        updatedUserRole.setName("New Role Not Yet Created");
        dao.saveOrUpdate(updatedUserRole);
        UserRole actualUserRole = (UserRole) dao.getById(1);
        assertNotNull(actualUserRole);
        assertEquals(updatedUserRole, actualUserRole);
    }

    /**
     * Validates insert is successful.
     */
    @Test
    void insertSuccess() {
        User insertUser = new User( "Mike", "Anderson", "mikeAnd23", "mike@yahoo.com", "234(3L!",
                LocalDateTime.of(2020, 3, 23, 10, 53),
                LocalDateTime.of(2020, 4, 3, 11, 34));
        UserRole insertUserRole = new UserRole("User",
                LocalDateTime.of(2020,1,1,0,0), insertUser);
        insertUser.addRole(insertUserRole);
        int insertId = dao.insert(insertUser);
        insertUser.setId(insertId);
        UserRole actualInsertUserRole = (UserRole) dao.getById(insertUserRole.getId());
        assertNotNull(actualInsertUserRole);
        assertEquals(insertUserRole, actualInsertUserRole);

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
     * Validates the get by property like is successful.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<UserRole> roles = dao.getByPropertyLike("name", "user");
        assertTrue(!roles.isEmpty());
        UserRole expectedUserRole = (UserRole) dao.getById(1);
        assertEquals(expectedUserRole, roles.get(0));
    }

    /**
     * Validates the get all is successful.
     */
    @Test
    void getAllSuccess() {
        List<UserRole> allRoles = dao.getAll();
        assertTrue(!allRoles.isEmpty());
        assertEquals(5, allRoles.size());
    }
}