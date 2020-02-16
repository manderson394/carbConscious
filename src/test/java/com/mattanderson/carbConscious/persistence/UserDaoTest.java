package com.mattanderson.carbConscious.persistence;

import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private UserDao dao;
    private User expectedUser;

    @BeforeEach
    void setUp() {
        dao = new UserDao();
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        database.runSQL("insertData.sql");

        expectedUser = new User(1, "Matt", "Anderson", "mattanderson",
                "matt@gmail.com", "testing",
                LocalDateTime.of(2020,1,1,0,0),
                LocalDateTime.of(2020, 1, 2, 0, 0));
    }

    @Test
    void getByIdSuccess() {
        User actualUser = dao.getById(1);
        assertNotNull(actualUser);
        assertEquals(expectedUser, actualUser);

    }

    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyEqual("userName", "mattanderson");
        assertNotNull(users);
        for (User user : users) {
            assertEquals(expectedUser, user);
        }
    }

    @Test
    void saveOrUpdateSuccess() {
        User updatedUser = new User(1, "Matt", "Peterson", "mattanderson",
                "matt@gmail.com", "testing",
                LocalDateTime.of(2020,1,1,0,0),
                LocalDateTime.of(2020, 1, 2, 0, 0));
        dao.saveOrUpdate(updatedUser);
        User actualUser = dao.getById(1);
        assertNotNull(actualUser);
        assertEquals(updatedUser, actualUser);
    }

    @Test
    void insertSuccess() {
        User insertUser = new User( "Mike", "Anderson", "mikeAnd23", "mike@yahoo.com", "234(3L!",
                LocalDateTime.of(2020, 3, 23, 10, 53),
                LocalDateTime.of(2020, 4, 3, 11, 34));
        int insertId = dao.insert(insertUser);
        insertUser.setId(insertId);
        User actualInsertUser = dao.getById(insertId);
        assertNotNull(actualInsertUser);
        assertEquals(insertUser, actualInsertUser);

    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }
}