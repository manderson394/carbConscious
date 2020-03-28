package com.mattanderson.carbConscious.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests the <code>UserFavorite</code> class.
 * @author Matt Anderson
 * @version 11
 */
class UserFavoriteTest {

    private UserFavorite favorite;
    private UserFavorite newFavorite;
    private User user;
    private MenuItem item;
    private MenuAPI api;

    /**
     * Sets up instance variables for unit tests.
     */
    @BeforeEach
    void setUp() {
        user = new User(1, "Matt", "Anderson", "mattanderson", "matt@gmail.com",
                "test1", LocalDateTime.of(2020, 1, 1, 1, 1),
                LocalDateTime.of(2020, 2, 2, 2, 2));
        UserRole role = new UserRole("User", LocalDateTime.of(2020, 1, 1, 1, 1), user);
        user.addRole(role);

        api = new MenuAPI("Matt's API");
        item = new MenuItem("Hot cakes", "", api, 23);
        favorite = new UserFavorite(1, 1,  user, item);
        newFavorite = new UserFavorite(2, 23, user, item);
    }

    /**
     * Validates getting id successfully.
     */
    @Test
    void getIdSuccess() {
        assertEquals(1, favorite.getId());
    }

    /**
     * Validates getting line successfully.
     */
    @Test
    void getLineSuccess() {
        assertEquals(1, favorite.getLine());
    }

    /**
     * Validates getting user successfully.
     */
    @Test
    void getUserSuccess() {
        assertEquals(user, favorite.getUser());
    }

    /**
     * Validates getting menu item successfully.
     */
    @Test
    void getMenuItemSuccess() {
        assertEquals(item, favorite.getMenuItem());
    }

    /**
     * Validates setting id successfully.
     */
    @Test
    void setIdSuccess() {
        favorite.setId(2);
        assertEquals(2, favorite.getId());
    }

    /**
     * Validates setting line successfully.
     */
    @Test
    void setLineSuccess() {
        favorite.setLine(2);
        assertEquals(2, favorite.getLine());
    }

    /**
     * Validates setting user successfully.
     */
    @Test
    void setUserSuccess() {
        User newUser = new User("Drew", "Peterson", "drewP", "de@aol.com", "tester",
                LocalDateTime.of(2020, 1, 1, 1, 1, 1),
                LocalDateTime.of(2020, 2, 1, 1, 1, 1));
        favorite.setUser(newUser);
        assertEquals(newUser, favorite.getUser());
    }

    /**
     * Validates setting menu item successfully.
     */
    @Test
    void setMenuItemSuccess() {
        MenuItem newItem = new MenuItem("test", "", api, 23);
        favorite.setMenuItem(newItem);
        assertEquals(newItem, favorite.getMenuItem());
    }

    /**
     * Validates the equality method successfully.
     */
    @Test
    void testEqualsSuccess() {
        assertEquals(favorite, favorite);
        assertNotEquals(newFavorite, favorite);
    }

    /**
     * Validates hash code generation is successful.
     */
    @Test
    void testHashCodeSuccess() {
        assertEquals(favorite, favorite);
        assertNotEquals(newFavorite, favorite);
    }

    /**
     * Validates to string generation success.
     */
    @Test
    void testToStringSuccess() {
        String expectedString = "UserFavorite(id=" +
                favorite.getId() + ", line=" +
                favorite.getLine() + ", user=" +
                favorite.getUser() + ", menuItem=" +
                favorite.getMenuItem() + ")";
        assertEquals(expectedString, favorite.toString());
    }
}