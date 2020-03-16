package com.spoonacular.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests the <code>SpoonacularMenuItem</code> class.
 */
class SpoonacularMenuItemTest {

    private SpoonacularMenuItem item;

    /**
     * Sets up instance variables for each unit test.
     */
    @BeforeEach
    void setUp() {
        item = new SpoonacularMenuItem("Hooters", "https://images.spoonacular.com/file/wximages/419357-312x231.png",
                419357, "1 cup", "Burger Sliders", "1c", "png");
    }

    /**
     * Validates getting restaurant chain successfully.
     */
    @Test
    void getRestaurantChainSuccess() {
        String expectedChain = "Hooters";
        assertEquals(expectedChain, item.getRestaurantChain());
    }

    /**
     * Validates getting image successfully.
     */
    @Test
    void getImageSuccess() {
        String expectedImage = "https://images.spoonacular.com/file/wximages/419357-312x231.png";
        assertEquals(expectedImage, item.getImage());
    }

    /**
     * Validates getting id successfully.
     */
    @Test
    void getIdSuccess() {
        int expectedId = 419357;
        assertEquals(expectedId, item.getId());
    }

    /**
     * Validates getting readable serving size successfully.
     */
    @Test
    void getReadableServingSizeSuccess() {
        String expectedReadableServingSize = "1 cup";
        assertEquals(expectedReadableServingSize, item.getReadableServingSize());
    }

    /**
     * Validates getting title successfully.
     */
    @Test
    void getTitleSuccess() {
        String expectedTitle = "Burger Sliders";
        assertEquals(expectedTitle, item.getTitle());
    }

    /**
     * Validates getting serving size successfully.
     */
    @Test
    void getServingSizeSuccess() {
        String expectedServingSize = "1c";
        assertEquals(expectedServingSize, item.getServingSize());
    }

    /**
     * Validates getting image type successfully.
     */
    @Test
    void getImageTypeSuccess() {
        String expectedImageType = "png";
        assertEquals(expectedImageType, item.getImageType());
    }

    /**
     * Validates setting restaurant chain successfully.
     */
    @Test
    void setRestaurantChainSuccess() {
        String expectedChain = "Burger King";
        item.setRestaurantChain(expectedChain);
        assertEquals(expectedChain, item.getRestaurantChain());
    }

    /**
     * Validates setting image successfully.
     */
    @Test
    void setImageSuccess() {
        String expectedImage = "//test.jpeg";
        item.setImage(expectedImage);
        assertEquals(expectedImage, item.getImage());
    }

    /**
     * Validates setting id successfully.
     */
    @Test
    void setIdSuccess() {
        int expectedId = 333;
        item.setId(expectedId);
        assertEquals(expectedId, item.getId());
    }

    /**
     * Validates setting readable serving size successfully.
     */
    @Test
    void setReadableServingSizeSuccess() {
        String expectedReadableServingSize = "spoon";
        item.setReadableServingSize(expectedReadableServingSize);
        assertEquals(expectedReadableServingSize, item.getReadableServingSize());
    }

    /**
     * Validates setting title successfully.
     */
    @Test
    void setTitleSuccess() {
        String expectedTitle = "blah";
        item.setTitle(expectedTitle);
        assertEquals(expectedTitle, item.getTitle());
    }

    /**
     * Validates setting serving size successfully.
     */
    @Test
    void setServingSizeSuccess() {
        String expectedServingSize = "sp";
        item.setServingSize(expectedServingSize);
        assertEquals(expectedServingSize, item.getServingSize());
    }

    /**
     * Validates setting image type successfully.
     */
    @Test
    void setImageTypeSuccess() {
        String expectedImageType = "jpeg";
        item.setImageType(expectedImageType);
        assertEquals(expectedImageType, item.getImageType());
    }

    /**
     * Tests to string success.
     */
    @Test
    void testToStringSuccess() {
        String expectedToString = "SpoonacularMenuItem(restaurantChain=Hooters, " +
                "image=https://images.spoonacular.com/file/wximages/419357-312x231.png, id=419357, " +
                "readableServingSize=1 cup, title=Burger Sliders, servingSize=1c, imageType=png)";
        assertEquals(expectedToString, item.toString());
    }
}