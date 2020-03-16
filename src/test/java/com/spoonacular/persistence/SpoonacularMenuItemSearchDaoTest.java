package com.spoonacular.persistence;

import com.mattanderson.carbConscious.util.PropertiesLoader;
import com.spoonacular.entity.SpoonacularMenuItem;
import com.spoonacular.entity.SpoonacularMenuItemSearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class SpoonacularMenuItemSearchDaoTest implements PropertiesLoader {

    private SpoonacularMenuItem item;
    private List<SpoonacularMenuItem> items = new ArrayList<>();
    private SpoonacularMenuItemSearch search;
    private SpoonacularDao<SpoonacularMenuItemSearch> dao;
    private Properties properties;

    @BeforeEach
    void setup() {
        dao = new SpoonacularDao<>(SpoonacularMenuItemSearch.class);
        item = new SpoonacularMenuItem("Hooters", "https://images.spoonacular.com/file/wximages/419357-312x231.png",
                419357, null, "Burger Sliders", null, "png");
        items =  new ArrayList<>();
        items.add(item);
        search = new SpoonacularMenuItemSearch(6749, 1,"234", 0, 151,
                items, "menuItem", false);

        properties = loadProperties("/api.properties");
    }

    @Test
    void createMenuItemSearchURISuccess() {
        String expectedURI = "https://api.spoonacular.com/food/menuItems/search?"
                + properties.getProperty("api.spoonacular.url.key") + "&query=soup&offset=438&number=343";
        dao.createMenuItemSearchURI("soup", 438, 343);
        assertEquals(expectedURI, dao.getQueryUri());
    }

    @Test
    void searchSpoonacularSuccess() {
        dao.createMenuItemSearchURI("burger", 0, 1);
        SpoonacularMenuItemSearch menuItemSearch = dao.searchSpoonacular();
        assertEquals(search, menuItemSearch);
    }
}