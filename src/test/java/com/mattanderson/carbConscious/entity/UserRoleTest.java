package com.mattanderson.carbConscious.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

class UserRoleTest {

    private UserRole userRole;
    private UserRole newRole;

    @BeforeEach
    void generateUserRole() {
        User user = new User(1, "Matt", "Anderson", "mattanderson", "matt@gmail.com", "testing", LocalDateTime.of(2020,1,1,0,0),
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

    @Test
    void getIdSuccess() {
        int id = userRole.getId();
        assertNotNull(id);
        assertEquals(1, 1);
    }

    @Test
    void setIdSuccess() {
        userRole.setId(2);
        assertNotNull(userRole.getId());
        assertEquals(2, userRole.getId());
    }

    @Test
    void getNameSuccess() {
        assertNotNull(userRole.getName());
        assertEquals("User", userRole.getName());
    }

    @Test
    void setNameSuccess() {
        userRole.setName("Test");
        assertNotNull(userRole.getName());
        assertEquals("Test", userRole.getName());
    }

    @Test
    void getCreationDateTimeSuccess() {
        assertNotNull(userRole.getCreationDateTime());
        assertEquals(LocalDateTime.of(2020, 1, 1, 10, 23), userRole.getCreationDateTime());
    }

    @Test
    void setCreationDateTimeSuccess() {
        userRole.setCreationDateTime(LocalDateTime.of(2020, 1, 1, 10, 45));
        assertNotNull(userRole.getCreationDateTime());
        assertEquals(LocalDateTime.of(2020, 1, 1, 10, 45), userRole.getCreationDateTime());
    }

    @Test
    void testToStringSuccess() {
        String expectedToString = "UserRole{" +
                "id=" + userRole.getId() +
                ", name='" + userRole.getName() + '\'' +
                ", creationDateTime=" + userRole.getCreationDateTime() +
                ", user=" + userRole.getUser() +
                '}';
        assertNotNull(userRole.toString());
        assertEquals(expectedToString, userRole.toString());
    }

    @Test
    void testEqualsSuccess() {
        assertEquals(userRole, userRole);
        assertNotEquals(newRole, userRole);
    }

    @Test
    void testHashCodeSuccess() {
        assertEquals(userRole.hashCode(), userRole.hashCode());
        assertNotEquals(userRole.hashCode(), newRole.hashCode());
    }
}