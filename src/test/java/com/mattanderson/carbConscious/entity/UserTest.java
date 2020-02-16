package com.mattanderson.carbConscious.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests the <code>User</code> java class.
 * @author Matt Anderson
 * @version 11
 */
class UserTest {

    private User user;
    private User newUser;

    /**
     * Generate user for each unit test.
     */
    @BeforeEach
    void generateUser() {
        user = new User(1, "Matt", "Anderson", "mattanderson", "matt@gmail.com",
                "test1", LocalDateTime.of(2020, 1, 1, 1, 1),
                LocalDateTime.of(2020, 2, 2, 2, 2));
        newUser = new User(2, "Matt", "Anderson", "mattanderson", "matt@gmail.com",
                "test1", LocalDateTime.of(2020, 1, 1, 1, 1),
                LocalDateTime.of(2020, 2, 2, 2, 2));
    }


    /**
     * Validates successful user object creation without specifying an id.
     */
    @Test
    void userCreationWithoutId() {
        User userNoId = new User( "Matt", "Anderson", "mattanderson", "matt@gmail.com",
                "test1", LocalDateTime.of(2020, 1, 1, 1, 1),
                LocalDateTime.of(2020, 2, 2, 2, 2));
        assertNotNull(userNoId);
    }
    /**
     * Validates successful ability to retrieve the user Id.
     */
    @Test
    void getIdSuccess() {
        assertNotNull(user.getId());
        assertEquals(1, user.getId());
    }

    /**
     * Validates successful ability to set the user Id.
     */
    @Test
    void setIdSuccess() {
        user.setId(2);
        assertNotNull(user.getId());
        assertEquals(2, user.getId());
    }

    /**
     * Validates successful ability to get the user first name.
     */
    @Test
    void getFirstNameSuccess() {
        assertNotNull(user.getFirstName());
        assertEquals("Matt", user.getFirstName());
    }

    /**
     * Validates successful ability to set the user first name.
     */
    @Test
    void setFirstNameSuccess() {
        user.setFirstName("Drew");
        assertNotNull(user.getFirstName());
        assertEquals("Drew", user.getFirstName());
    }

    /**
     * Validates successful ability to get the user last name.
     */
    @Test
    void getLastNameSuccess() {
        assertNotNull(user.getLastName());
        assertEquals("Anderson", user.getLastName());
    }

    /**
     * Validates successful ability to set the user last name.
     */
    @Test
    void setLastNameSuccess() {
        user.setLastName("Peterson");
        assertNotNull(user.getLastName());
        assertEquals("Peterson", user.getLastName());
    }

    /**
     * Validates successful ability too get the user name.
     */
    @Test
    void getUserNameSuccess() {
        assertNotNull(user.getUserName());
        assertEquals("mattanderson", user.getUserName());
    }

    /**
     * Validates successful ability to set the user name.
     */
    @Test
    void setUserNameSuccess() {
        user.setUserName("drewPeterson");
        assertNotNull(user.getUserName());
        assertEquals("drewPeterson", user.getUserName());
    }

    /**
     * Validates successful ability to get user email.
     */
    @Test
    void getEmailSuccess() {
        assertNotNull(user.getEmail());
        assertEquals("matt@gmail.com", user.getEmail());
    }

    /**
     * Validates successful ability to set user email.
     */
    @Test
    void setEmailSuccess() {
        user.setEmail("test@aol.com");
        assertNotNull(user.getEmail());
        assertEquals("test@aol.com", user.getEmail());
    }

    /**
     * Validates successful ability to get the user password.
     */
    @Test
    void getPasswordSuccess() {
        assertNotNull(user.getPassword());
        assertEquals("test1", user.getPassword());
    }

    /**
     * Validates the successful ability to set the user password.
     */
    @Test
    void setPasswordSuccess() {
        user.setPassword("test2");
        assertNotNull(user.getPassword());
        assertEquals("test2", user.getPassword());
    }

    /**
     * Validates the successful ability to get the user creation date time.
     */
    @Test
    void getCreationDateTimeSuccess() {
        assertNotNull(user.getCreationDateTime());
        assertEquals(LocalDateTime.of(2020, 1, 1, 1, 1), user.getCreationDateTime());
    }

    /**
     * Validates the successful ability to set the user creation date time.
     */
    @Test
    void setCreationDateTimeSuccess() {
        user.setCreationDateTime(LocalDateTime.of(2020, 1, 1, 1, 23));
        assertNotNull(user.getCreationDateTime());
        assertEquals(LocalDateTime.of(2020, 1, 1, 1, 23), user.getCreationDateTime());
    }

    /**
     * Validates the successful ability to get the user update date time.
     */
    @Test
    void getUpdateDateTimeSuccess() {
        assertNotNull(user.getUpdateDateTime());
        assertEquals(LocalDateTime.of(2020, 2, 2, 2, 2), user.getUpdateDateTime());
    }

    /**
     * Validates the successful ability to set the user update date time.
     */
    @Test
    void setUpdateDateTimeSuccess() {
        user.setUpdateDateTime(LocalDateTime.of(2020, 2, 2, 2, 34));
        assertNotNull(user.getUpdateDateTime());
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

    /**
     * Validates the user <code>equals</code> method works as expected.
     */
    @Test
    void testEqualsSuccess() {
        assertEquals(user, user);
        assertNotEquals(user, newUser);
    }

    /**
     * Validates the user <code>hashCode</code> method behaves as expected.
     */
    @Test
    void testHashCodeSuccess() {
        assertEquals(user.hashCode(), user.hashCode());
        assertNotEquals(user.hashCode(), newUser.hashCode());
    }
}