package com.spoonacular.entity;

import com.mattanderson.carbConscious.test.util.PropertiesLoader;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit tests the <code>SpoonacularMenuItemSearch</code> class.
 * @author Matt Anderson
 * @version 11
 */
@Log4j2
public class SpoonacularMenuItemSearchTest implements PropertiesLoader {

    private SpoonacularMenuItemSearch search;
    private SpoonacularMenuItem item;
    private List<SpoonacularMenuItem> items;

    /**
     * Sets up variables for each test.
     */
    @BeforeEach
    public void setup() {
        item = new SpoonacularMenuItem("Hooters", "https://images.spoonacular.com/file/wximages/419357-312x231.png",
                419357, null, "Burger Sliders", null, "png");
        items =  new ArrayList<>();
        items.add(item);
        search = new SpoonacularMenuItemSearch(6749, 1,"234", 0, 151,
                items, "menuItem", false);
    }

    /**
     * Validates getting total menu items successfully.
     */
    @Test
    void getTotalMenuItemsSuccess() {
        int expectedTotal = 6749;
        assertEquals(expectedTotal, search.getTotalMenuItems());
    }

    /**
     * Validates getting number successfully.
     */
    @Test
    void getNumberSuccess() {
        int expectedNumber = 1;
        assertEquals(expectedNumber, search.getNumber());
    }

    /**
     * Validates getting expires successfully.
     */
    @Test
    void getExpiresSuccess() {
        String expectedExpires = "234";
        assertEquals(expectedExpires, search.getExpires());
    }

    /**
     * Validates getting offset successfully.
     */
    @Test
    void getOffsetSuccess() {
        int expectedOffset = 0;
        assertEquals(expectedOffset, search.getOffset());
    }

    /**
     * Validates getting processing time ms successfully.
     */
    @Test
    void getProcessingTimeMsSuccess() {
        int expectedProcessingTime = 151;
        assertEquals(expectedProcessingTime, search.getProcessingTimeMs());
    }

    /**
     * Validates getting menu items successfully.
     */
    @Test
    void getMenuItemsSuccess() {
        List<SpoonacularMenuItem> actualItems = search.getMenuItems();
        assertEquals(1, actualItems.size());
        for (SpoonacularMenuItem actualItem : actualItems) {
            assertEquals(item, actualItem);
        }
    }

    /**
     * Validates getting type successfully.
     */
    @Test
    void getTypeSuccess() {
        String expectedType = "menuItem";
        assertEquals(expectedType, search.getType());
    }

    /**
     * Validates setting is stale successfully.
     */
    @Test
    void isStaleSuccess() {
        assertFalse(search.isStale());
    }

    /**
     * Validates setting total menu items successfully.
     */
    @Test
    void setTotalMenuItemsSuccess() {
        int expectedTotal = 343;
        search.setTotalMenuItems(expectedTotal);
        assertEquals(expectedTotal, search.getTotalMenuItems());
    }

    /**
     * Validates setting number successfully.
     */
    @Test
    void setNumberSuccess() {
        int expectedNumber = 33;
        search.setNumber(expectedNumber);
        assertEquals(expectedNumber, search.getNumber());
    }

    /**
     * Validates setting expires successfully.
     */
    @Test
    void setExpiresSuccess() {
        String expectedExpires = "343333";
        search.setExpires(expectedExpires);
        assertEquals(expectedExpires, search.getExpires());
    }

    /**
     * Validates setting offset successfully.
     */
    @Test
    void setOffsetSuccess() {
        int expectedOffset = 33;
        search.setOffset(expectedOffset);
        assertEquals(expectedOffset, search.getOffset());
    }

    /**
     * Validates setting processing time ms successfully.
     */
    @Test
    void setProcessingTimeMsSuccess() {
        int expectedProcessingTime = 34334;
        search.setProcessingTimeMs(expectedProcessingTime);
        assertEquals(expectedProcessingTime, search.getProcessingTimeMs());
    }

    /**
     * Validates setting menu items successfully.
     */
    @Test
    void setMenuItemsSuccess() {
        List<SpoonacularMenuItem> expectedItems = new ArrayList<>();
        SpoonacularMenuItem expectedItem = new SpoonacularMenuItem("Burger King", "https://images.spoonacular.com/test.jpeg",
                3333, "testing", "Burger", "test", "jpeg");
        expectedItems.add(expectedItem);
        search.setMenuItems(expectedItems);

        List<SpoonacularMenuItem> actualItems = search.getMenuItems();
        assertEquals(1, actualItems.size());
        for (SpoonacularMenuItem actualItem : actualItems) {
            assertEquals(expectedItem, actualItem);
        }
    }

    /**
     * Validates setting type successfully.
     */
    @Test
    void setTypeSuccess() {
        String expectedType = "testing";
        search.setType(expectedType);
        assertEquals(expectedType, search.getType());
    }

    /**
     * Validates setting the search to stale successfully.
     */
    @Test
    void setStaleSuccess() {
        boolean expectedStale = true;
        search.setStale(expectedStale);
        assertTrue(search.isStale());
    }

    /**
     * Test to string.
     */
    @Test
    void testToString() {
        String expectedToString = "SpoonacularMenuItemSearch(totalMenuItems=6749, number=1, expires=234, offset=0, " +
                "processingTimeMs=151, menuItems=[SpoonacularMenuItem(restaurantChain=Hooters, " +
                "image=https://images.spoonacular.com/file/wximages/419357-312x231.png, id=419357, " +
                "readableServingSize=null, title=Burger Sliders, servingSize=null, imageType=png)], type=menuItem, " +
                "isStale=false)";
        assertEquals(expectedToString, search.toString());
    }
}
