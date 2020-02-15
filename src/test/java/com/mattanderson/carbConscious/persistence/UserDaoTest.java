package com.mattanderson.carbConscious.persistence;

import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private UserDao dao;

    @BeforeEach
    void setUp() {
        dao = new UserDao();
        Database database = Database.getInstance();
        database.runSQL("cleanUserDB.sql");
    }

    @Test
    void getByIdSuccess() {
        User user = dao.getById(1);
        User expectedUser = new User(1, "Matt", "Anderson", "mattanderson", "matt@gmail.com", "testing",
                LocalDateTime.of(2020,1,1,0,0),
                LocalDateTime.of(2020, 1, 2, 0, 0));

    }

    @Test
    void getByPropertyEqualSuccess() {
    }

    @Test
    void saveOrUpdateSuccess() {
    }

    @Test
    void insertSuccess() {
    }

    @Test
    void deleteSuccess() {
    }
}