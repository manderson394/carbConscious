package com.mattanderson.carbConscious.util;

import com.mattanderson.carbConscious.entity.MenuItem;
import com.mattanderson.carbConscious.entity.Restaurant;
import com.mattanderson.carbConscious.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests the <code>GenericValidator</code> class.
 * @author Matt Anderson
 * @version 11
 */
class GenericValidatorTest {

    private GenericValidator<User> userValidator = new GenericValidator<>(User.class);
    private GenericValidator<MenuItem> itemValidator = new GenericValidator<>(MenuItem.class);
    private GenericValidator<Restaurant> restaurantValidator = new GenericValidator<>(Restaurant.class);

    /**
     * Verifies successful user validation.
     */
    @Test
    void validateUserSuccess() {
        User user = new User("Matt", "", "", "j", "");

        Map<String, String> errors = userValidator.validate(user);

        assertEquals(4, errors.size());
    }

    /**
     * Verifies successful menu item validation.
     */
    @Test
    void validateMenuItemSuccess() {
        MenuItem item = new MenuItem("", "2222222222222222222222222222222222222sdlk;fajssdlfkja;sflkjads;flkjasldfjas" +
                ";aslkdfj;aslkdfja;slkdfja;slkfdja;sldfkja;sldkfjas;ldkjlskfjalsdkfjsa;ldkfj;asldkfja;slkdfjas;lfdkja" +
                ";asldkfa;slkdfja;slkdfj;aslkdfj;aslkdfj;aslkfdj;aslkdfja;sldkfj;aslkdfj;aslkdfj;aslkdfj;aslkfdj;aslk" +
                "a;sldkfja;slkdfj;aslkdfj;aslkdfja;slkfdjas;lkdfjahadfjbkldjfvnldkvnaslndv;alsdkvans;vdljadnk;jfnkjdv" +
                "asiofnogniaeoginldfkgnsldfkgnsdjfghsdlkfjgkldjflkjdfalskdfhhaurgnkjbnlfkjbnlkjslfkjdghslkjdflsdfkjgh",
                new Restaurant());

        Map<String, String> errors = itemValidator.validate(item);

        assertEquals(2, errors.size());
    }

    /**
     * Verifies successful restaurant validation.
     */
    @Test
    void validateRestaurantSuccess() {
        Restaurant restaurant = new Restaurant("", "", "", "", "");

        Map<String, String> errors = restaurantValidator.validate(restaurant);

        assertEquals(5, errors.size());
    }
}