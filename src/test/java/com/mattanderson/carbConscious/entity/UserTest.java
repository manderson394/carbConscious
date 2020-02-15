package com.mattanderson.carbConscious.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests the <code>User</code> java class.
 * @author Matt Anderson
 * @version 11
 */
class UserTest {

    private User user;

    /**
     * Generate user for each unit test.
     */
    @BeforeEach
    void generateUser() {
        user = new User(1, "Matt", "Anderson", "mattanderson", "matt@gmail.com",
                "test1", LocalDateTime.of(2020, 1, 1, 1, 1),
                LocalDateTime.of(2020, 2, 2, 2, 2));
    }


    /**
     * Validates successful ability to retrieve the user Id.
     */
    @Test
    void getIdSuccess() {
        assertEquals(1, user.getId());
    }

    /**
     * Validates successful ability to set the user Id.
     */
    @Test
    void setIdSuccess() {
        user.setId(2);
        assertEquals(2, user.getId());
    }

    /**
     * Validates successful ability to get the user first name.
     */
    @Test
    void getFirstNameSuccess() {
        assertEquals("Matt", user.getFirstName());
    }

    /**
     * Validates successful ability to set the user first name.
     */
    @Test
    void setFirstNameSuccess() {
        user.setFirstName("Drew");
        assertEquals("Drew", user.getFirstName());
    }

    /**
     * Validates successful ability to get the user last name.
     */
    @Test
    void getLastNameSuccess() {
        assertEquals("Anderson", user.getLastName());
    }

    /**
     * Validates successful ability to set the user last name.
     */
    @Test
    void setLastNameSuccess() {
        user.setLastName("Peterson");
        assertEquals("Peterson", user.getLastName());
    }

    /**
     * Validates successful ability too get the user name.
     */
    @Test
    void getUserNameSuccess() {
        assertEquals("mattanderson", user.getUserName());
    }

    /**
     * Validates successful ability to set the user name.
     */
    @Test
    void setUserNameSuccess() {
        user.setUserName("drewPeterson");
        assertEquals("drewPeterson", user.getUserName());
    }

    /**
     * Validates successful ability to get the user password.
     */
    @Test
    void getPasswordSuccess() {
        assertEquals("test1", user.getPassword());
    }

    /**
     * Validates the successful ability to set the user password.
     */
    @Test
    void setPasswordSuccess() {
        user.setPassword("test2");
        assertEquals("test2", user.getPassword());
    }

    /**
     * Validates the successful ability to get the user creation date time.
     */
    @Test
    void getCreationDateTimeSuccess() {
        assertEquals(LocalDateTime.of(2020, 1, 1, 1, 1), user.getCreationDateTime());
    }

    /**
     * Validates the successful ability to set the user creation date time.
     */
    @Test
    void setCreationDateTimeSuccess() {
        user.setCreationDateTime(LocalDateTime.of(2020, 1, 1, 1, 23));
        assertEquals(LocalDateTime.of(2020, 1, 1, 1, 23), user.getCreationDateTime());
    }

    /**
     * Validates the successful ability to get the user update date time.
     */
    @Test
    void getUpdateDateTimeSuccess() {
        assertEquals(LocalDateTime.of(2020, 2, 2, 2, 2), user.getUpdateDateTime());
    }

    /**
     * Validates the successful ability to set the user update date time.
     */
    @Test
    void setUpdateDateTimeSuccess() {
        user.setUpdateDateTime(LocalDateTime.of(2020, 2, 2, 2, 34));
        assertEquals(LocalDateTime.of(2020, 2, 2, 2, 34), user.getUpdateDateTime());
    }

    /**
     * Validates the user <code>toString</code> method.
     */
    @Test
    void testToStringSuccess() {
        String expectedToString = "User{" +
                "id=" + user.getId() +
                ", firstName='" + user.getFirstName() + '\'' +
                ", lastName='" + user.getLastName() + '\'' +
                ", userName='" + user.getUserName() + '\'' +
                ", email='" + user.getEmail() + '\'' +
                ", password='" + user.getPassword() + '\'' +
                ", creationDateTime=" + user.getCreationDateTime() +
                ", updateDateTime=" + user.getUpdateDateTime() +
                '}';
        assertEquals(expectedToString, user.toString());
    }
}