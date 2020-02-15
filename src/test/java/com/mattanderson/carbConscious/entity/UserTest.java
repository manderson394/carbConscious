package com.mattanderson.carbConscious.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void generateUser() {
        user = new User(1, "Matt", "Anderson", "mattanderson", "test1",
                LocalDateTime.of(2020, 1, 1, 1, 1),
                LocalDateTime.of(2020, 2, 2, 2, 2));
    }


    @Test
    void getId() {
        assertEquals(1, user.getId());
    }

    @Test
    void setId() {
        user.setId(2);
        assertEquals(2, user.getId());
    }

    @Test
    void getFirstName() {
        assertEquals("Matt", user.getFirstName());
    }

    @Test
    void setFirstName() {
        user.setFirstName("Drew");
        assertEquals("Drew", user.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Anderson", user.getLastName());
    }

    @Test
    void setLastName() {
        user.setLastName("Peterson");
        assertEquals("Peterson", user.getLastName());
    }

    @Test
    void getUserName() {
        assertEquals("mattanderson", user.getUserName());
    }

    @Test
    void setUserName() {
        user.setUserName("drewPeterson");
        assertEquals("drewPeterson", user.getUserName());
    }

    @Test
    void getPassword() {
        assertEquals("test1", user.getPassword());
    }

    @Test
    void setPassword() {
        user.setPassword("test2");
        assertEquals("test2", user.getPassword());
    }

    @Test
    void getCreationDateTime() {
        assertEquals(LocalDateTime.of(2020, 1, 1, 1, 1), user.getCreationDateTime());
    }

    @Test
    void setCreationDateTime() {
        user.setCreationDateTime(LocalDateTime.of(2020, 1, 1, 1, 23));
        assertEquals(LocalDateTime.of(2020, 1, 1, 1, 23), user.getCreationDateTime());
    }

    @Test
    void getUpdateDateTime() {
        assertEquals(LocalDateTime.of(2020, 2, 2, 2, 2), user.getUpdateDateTime());
    }

    @Test
    void setUpdateDateTime() {
        user.setUpdateDateTime(LocalDateTime.of(2020, 2, 2, 2, 34));
        assertEquals(LocalDateTime.of(2020, 2, 2, 2, 34), user.getUpdateDateTime());
    }

    @Test
    void testToString() {
        String expectedToString = "User{" +
                "id=" + user.getId() +
                ", firstName='" + user.getFirstName() + '\'' +
                ", lastName='" + user.getLastName() + '\'' +
                ", userName='" + user.getUserName() + '\'' +
                ", password='" + user.getPassword() + '\'' +
                ", creationDateTime=" + user.getCreationDateTime() +
                ", updateDateTime=" + user.getUpdateDateTime() +
                '}';
        assertEquals(expectedToString, user.toString());
    }
}