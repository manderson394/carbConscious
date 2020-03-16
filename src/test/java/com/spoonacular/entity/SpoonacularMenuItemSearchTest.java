package com.spoonacular.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void MenuItemSearchSuccess() {
        Client client = ClientBuilder.newClient();
        String uri = baseUri + "&query=burger&number=1";
        WebTarget target = client.target(uri);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        SpoonacularMenuItemSearch spoonacularMenuItemSearch = null;
        try {
            spoonacularMenuItemSearch = mapper.readValue(response, SpoonacularMenuItemSearch.class);
        } catch (JsonProcessingException e) {
            log.error("JSON Processing Exception when mapping to SpoonacularMenuItem class", e);
        }
        assertEquals(search, spoonacularMenuItemSearch);
    }


}
