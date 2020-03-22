package com.mattanderson.carbConscious.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests the <code>User</code> java class.
 * @author Matt Anderson
 * @version 11
 */
class UserTest {

    private User user;
    private User newUser;
    private MenuAPI api;
    private MenuItem item;
    private UserFavorite favorite;
    private CarbohydratesEstimate estimate;

    /**
     * Generate user for each unit test.
     */
    @BeforeEach
    void generateUser() {
        user = new User(1, "Matt", "Anderson", "mattanderson", "matt@gmail.com",
                "test1", LocalDateTime.of(2020, 1, 1, 1, 1),
                LocalDateTime.of(2020, 2, 2, 2, 2));
        UserRole role = new UserRole("User", LocalDateTime.of(2020, 1, 1, 1, 1), user);
        user.addRole(role);

        newUser = new User(2, "Matt", "Anderson", "mattanderson", "matt@gmail.com",
                "test1", LocalDateTime.of(2020, 1, 1, 1, 1),
                LocalDateTime.of(2020, 2, 2, 2, 2));
        UserRole newRole = new UserRole("Administrator",  LocalDateTime.of(2020, 1, 1, 1, 1), newUser);

        api = new MenuAPI("Matt's API");
        item = new MenuItem("Hot cakes", api, 23);
        favorite = new UserFavorite(1,  user, item);
        estimate = new CarbohydratesEstimate(80, item, Outcome.fromId(2), user);
    }

    /**
     * Validates successful User object creation with basic user data.
     */
    @Test
    void userCreationBasicSuccess() {
        User basicUser = new User("New", "User", "basicUser", "basic@aol.com", "testBasic");
        assertNotNull(basicUser);
    }

    /**
     * Validates successful User object creation with basic user data and an ID.
     */
    @Test
    void userCreationBasicWithIdSuccess() {
        User basicUserId = new User(23, "new", "basic", "user", "test@live.com", "tester");
        assertNotNull(basicUserId);
    }

    /**
     * Validates successful User object creation with Id specification.
     */
    @Test
    void userCreationWithIdSuccess() {
        Set<UserRole> withIdUserUserRoles = new HashSet<>();
        withIdUserUserRoles.add(new UserRole("User",  LocalDateTime.of(2020, 1, 1, 1, 1),
                new User( "Matt", "Anderson", "mattanderson", "matt@gmail.com",
                        "test1", LocalDateTime.of(2020, 1, 1, 1, 1),
                        LocalDateTime.of(2020, 2, 2, 2, 2))));
        User userWithId = new User( 12,"Matt", "Anderson", "mattanderson", "matt@gmail.com",
                "test1", LocalDateTime.of(2020, 1, 1, 1, 1),
                LocalDateTime.of(2020, 2, 2, 2, 2), withIdUserUserRoles);
        assertNotNull(userWithId);
    }

    /**
     * Validates successful user object creation without specifying an id.
     */
    @Test
    void userCreationWithoutIdSuccess() {
        Set<UserRole> noIdUserUserRoles = new HashSet<>();
        noIdUserUserRoles.add(new UserRole("User",  LocalDateTime.of(2020, 1, 1, 1, 1),
                new User( "Matt", "Anderson", "mattanderson", "matt@gmail.com",
                "test1", LocalDateTime.of(2020, 1, 1, 1, 1),
                LocalDateTime.of(2020, 2, 2, 2, 2))));
        User userNoId = new User( "Matt", "Anderson", "mattanderson", "matt@gmail.com",
                "test1", LocalDateTime.of(2020, 1, 1, 1, 1),
                LocalDateTime.of(2020, 2, 2, 2, 2), noIdUserUserRoles);
        assertNotNull(userNoId);
    }

    /**
     * Validates successful User constructions with all non-ID instance variables.
     */
    @Test
    void userCreationAllInstanceVariablesSuccess() {
        Set<UserRole> allRoles = new HashSet<>();
        Set<UserFavorite> allFavorites = new HashSet<>();
        Set<CarbohydratesEstimate> allEstimates = new HashSet<>();
        allRoles.add(new UserRole("User",  LocalDateTime.of(2020, 1, 1, 1, 1),
                new User( "Matt", "Anderson", "mattanderson", "matt@gmail.com",
                        "test1", LocalDateTime.of(2020, 1, 1, 1, 1),
                        LocalDateTime.of(2020, 2, 2, 2, 2))));
        allFavorites.add(favorite);
        allEstimates.add(estimate);

        User allUser = new User( "Matt", "Anderson", "mattanderson", "matt@gmail.com",
                "test1", LocalDateTime.of(2020, 1, 1, 1, 1),
                LocalDateTime.of(2020, 2, 2, 2, 2), allRoles, allFavorites, allEstimates);
        assertNotNull(allUser);
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
     * Validates successful role retreival.
     */
    @Test
    void getRolesSuccess() {
        UserRole expectedRole = new UserRole("User",  LocalDateTime.of(2020, 1, 1, 1, 1), user);
        Set<UserRole> expectedSet = new HashSet<>();
        expectedSet.add(expectedRole);
        assertNotNull(user.getRoles());
        assertEquals(expectedSet, user.getRoles());

    }

    /**
     * Validates successful role setting.
     */
    @Test
    void setRolesSuccess() {
        UserRole newRole = new UserRole("Administrator",  LocalDateTime.of(2020, 1, 1, 1, 1), user);
        Set<UserRole> newSet = new HashSet<>();
        newSet.add(newRole);
        user.setRoles(newSet);
        assertNotNull(user.getRoles());
        assertEquals(newSet, user.getRoles());

    }

    /**
     * Validates roles can successfully be added to the user.
     */
    @Test
    void addRoleSuccess() {
        UserRole addition = new UserRole("Administrator",  LocalDateTime.of(2020, 1, 1, 1, 1), user);
        user.addRole(addition);
        assertEquals(true, user.getRoles().contains(addition));
    }

    /**
     * Validates roles can be successfully removed from the user.
     */
    @Test
    void removeRoleSuccess() {
        UserRole removal = new UserRole("Administrator",  LocalDateTime.of(2020, 1, 1, 1, 1), user);
        user.addRole(removal);
        user.removeRole(removal);
        assertEquals(false, user.getRoles().contains(removal));
        assertEquals(1, user.getRoles().size());
    }

    /**
     * Validates successful favorite addition to a user.
     */
    @Test
    void addFavoriteSuccess() {
        user.addFavorite(favorite);
        Set<UserFavorite> favorites = user.getFavorites();
        assertEquals(1, favorites.size());
        for (UserFavorite fav : favorites) {
            assertEquals(favorite, fav);
        }
    }

    /**
     * Validates successful favorite removal from a user.
     */
    @Test
    void removeFavoriteSuccess() {
        user.addFavorite(favorite);
        assertEquals(1, user.getFavorites().size());
        user.removeFavorite(favorite);
        assertEquals(0, user.getFavorites().size());
    }

    /**
     * Validates successful estimate addition to a user.
     */
    @Test
    void addCarbohydrateEstimate() {
        user.addCarbohydratesEstimate(estimate);
        assertEquals(1, user.getEstimates().size());
        for (CarbohydratesEstimate estimateTest : user.getEstimates()) {
            assertEquals(estimate, estimateTest);
        }
    }

    /**
     * Validates successful estimate removal from a user.
     */
    @Test
    void removeCarbohydrateEstimate() {
        user.addCarbohydratesEstimate(estimate);
        assertEquals(1, user.getEstimates().size());
        user.removeCarbohydratesEstimate(estimate);
        assertEquals(0, user.getEstimates().size());
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