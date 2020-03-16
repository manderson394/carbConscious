package com.spoonacular.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mattanderson.carbConscious.entity.MenuItem;
import com.mattanderson.carbConscious.test.util.PropertiesLoader;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@Log4j2
public class SpoonacularMenuItemSearchTest implements PropertiesLoader {

    private Properties properties;
    private String baseUri;
    private SpoonacularMenuItemSearch search;
    private SpoonacularMenuItem item;
    private List<SpoonacularMenuItem> items;

    @BeforeEach
    public void setup() {
        properties = loadProperties("/api.properties");
        baseUri = properties.getProperty("api.spoonacular.url")
                + properties.getProperty("api.spoonacular.menu.item.search.url") + "apiKey="
                + properties.getProperty("api.spoonacular.url.key");
        item = new SpoonacularMenuItem("Hooters", "https://images.spoonacular.com/file/wximages/419357-312x231.png",
                419357, null, "Burger Sliders", null, "png");
        items =  new ArrayList<>();
        items.add(item);
        search = new SpoonacularMenuItemSearch(6749, 1,"234", 0, 151,
                items, "menuItem", false);
    }

    @Test
    void getTotalMenuItemsSuccess() {
        int expectedTotal = 6749;
        assertEquals(expectedTotal, search.getTotalMenuItems());
    }

    @Test
    void getNumberSuccess() {
        int expectedNumber = 1;
        assertEquals(expectedNumber, search.getNumber());
    }

    @Test
    void getExpiresSucccess() {
        String expectedExpires = "234";
        assertEquals(expectedExpires, search.getExpires());
    }

    @Test
    void getOffsetSuccess() {
        int expectedOffset = 0;
        assertEquals(expectedOffset, search.getOffset());
    }

    @Test
    void getProcessingTimeMsSuccess() {
        int expectedProcessingTime = 151;
        assertEquals(expectedProcessingTime, search.getProcessingTimeMs());
    }

    @Test
    void getMenuItemsSuccess() {
        List<SpoonacularMenuItem> actualItems = search.getMenuItems();
        assertEquals(1, actualItems.size());
        for (SpoonacularMenuItem actualItem : actualItems) {
            assertEquals(item, actualItem);
        }
    }

    @Test
    void getTypeSuccess() {
        String expectedType = "menuItem";
        assertEquals(expectedType, search.getType());
    }

    @Test
    void isStaleSuccessSuccess() {
        assertFalse(search.isStale());
    }

    @Test
    void setTotalMenuItemsSuccess() {
        int expectedTotal = 343;
        search.setTotalMenuItems(expectedTotal);
        assertEquals(expectedTotal, search.getTotalMenuItems());
    }

    @Test
    void setNumberSuccess() {
        int expectedNumber = 33;
        search.setNumber(expectedNumber);
        assertEquals(expectedNumber, search.getNumber());
    }

    @Test
    void setExpiresSuccess() {
        String expectedExpires = "343333";
        search.setExpires(expectedExpires);
        assertEquals(expectedExpires, search.getExpires());
    }

    @Test
    void setOffsetSuccess() {
        int expectedOffset = 33;
        search.setOffset(expectedOffset);
        assertEquals(expectedOffset, search.getOffset());
    }

    @Test
    void setProcessingTimeMsSuccess() {
        int expectedProcessingTime = 34334;
        search.setProcessingTimeMs(expectedProcessingTime);
        assertEquals(expectedProcessingTime, search.getProcessingTimeMs());
    }

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

    @Test
    void setType() {
        String expectedType = "testing";
        search.setType(expectedType);
        assertEquals(expectedType, search.getType());
    }

    @Test
    void setStale() {
        boolean expectedStale = true;
        search.setStale(expectedStale);
        assertEquals(true, search.isStale());
    }

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
