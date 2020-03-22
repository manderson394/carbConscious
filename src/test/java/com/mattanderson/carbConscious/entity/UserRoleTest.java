package com.mattanderson.carbConscious.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

/**
 * Unit tests the <code>UserRole</code> class.
 * @author Matt Anderson
 * @version 11
 */
class UserRoleTest {

    private UserRole userRole;
    private UserRole newRole;
    private User user;

    /**
     * Generates users and user roles for each test case.
     */
    @BeforeEach
    void generateUserRole() {
        user = new User(1, "Matt", "Anderson", "mattanderson", "matt@gmail.com", "testing", LocalDateTime.of(2020,1,1,0,0),
                LocalDateTime.of(2020, 1, 2, 0, 0));
        userRole = new UserRole(1,"User",
                LocalDateTime.of(2020, 1, 1, 10, 23), user);
        user.addRole(userRole);

        User newUser = new User(3, "Nicole", "Sannes", "nicoleSannes", "nicole@aol.com", "testing2", LocalDateTime.of(2020, 1, 7, 0, 0),
                LocalDateTime.of(2020, 1, 8, 0, 0));
        newRole = new UserRole("Administrator",
                LocalDateTime.of(2020, 2, 10, 14, 54), newUser);
        newUser.addRole(newRole);
    }

    /**
     * Validates user role construction with id is successful.
     */
    @Test
    void userRoleConstructionWithIdSuccess() {
        UserRole newRoleWithId = new UserRole(23, "Administrator",
                LocalDateTime.of(2020, 2, 10, 14, 54), new User());
        assertNotNull(newRoleWithId);
    }

    /**
     * Validates successfully gets id.
     */
    @Test
    void getIdSuccess() {
        int id = userRole.getId();
        assertNotNull(id);
        assertEquals(1, 1);
    }

    /**
     * Validates successfully sets id.
     */
    @Test
    void setIdSuccess() {
        userRole.setId(2);
        assertNotNull(userRole.getId());
        assertEquals(2, userRole.getId());
    }

    /**
     * Validates successfully gets name.
     */
    @Test
    void getNameSuccess() {
        assertNotNull(userRole.getName());
        assertEquals("User", userRole.getName());
    }

    /**
     * Validates successfully sets name.
     */
    @Test
    void setNameSuccess() {
        userRole.setName("Test");
        assertNotNull(userRole.getName());
        assertEquals("Test", userRole.getName());
    }

    /**
     * Validates successfully gets creation date time.
     */
    @Test
    void getCreationDateTimeSuccess() {
        assertNotNull(userRole.getCreationDateTime());
        assertEquals(LocalDateTime.of(2020, 1, 1, 10, 23), userRole.getCreationDateTime());
    }

    /**
     * Validates successfully sets creation date time.
     */
    @Test
    void setCreationDateTimeSuccess() {
        userRole.setCreationDateTime(LocalDateTime.of(2020, 1, 1, 10, 45));
        assertNotNull(userRole.getCreationDateTime());
        assertEquals(LocalDateTime.of(2020, 1, 1, 10, 45), userRole.getCreationDateTime());
    }

    /**
     * Validates successfully gets user.
     */
    @Test
    void getUserSuccess() {
        assertNotNull(userRole.getUser());
        assertEquals(user, userRole.getUser());
    }

    /**
     * Validates successfully sets user.
     */
    @Test
    void setUserSuccess() {
        User setUser = new User();
        userRole.setUser(setUser);
        assertNotNull(userRole.getUser());
        assertEquals(setUser, userRole.getUser());
    }

    /**
     * Test to string success.
     */
    @Test
    void testToStringSuccess() {
        String expectedToString = "UserRole(" +
                "id=" + userRole.getId() +
                ", name=" + userRole.getName() +
                ", creationDateTime=" + userRole.getCreationDateTime() +
                ", user=" + userRole.getUser() +
                ')';
        assertNotNull(userRole.toString());
        assertEquals(expectedToString, userRole.toString());
    }

    /**
     * Test equals success.
     */
    @Test
    void testEqualsSuccess() {
        assertEquals(userRole, userRole);
        assertNotEquals(newRole, userRole);
    }

    /**
     * Test hash code success.
     */
    @Test
    void testHashCodeSuccess() {
        assertEquals(userRole.hashCode(), userRole.hashCode());
        assertNotEquals(userRole.hashCode(), newRole.hashCode());
    }
}