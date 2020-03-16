package com.spoonacular.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mattanderson.carbConscious.util.PropertiesLoader;
import com.spoonacular.entity.SpoonacularMenuItemSearch;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import javax.json.Json;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Properties;

@Log4j2
public class SpoonacularDao<T> implements PropertiesLoader {

    private String baseUri;
    private String searchMenuItemsString;
    private String authenticationString;
    private Properties properties;
    private Client client;
    private ObjectMapper mapper;
    private Class<T> type;
    @Getter
    private String queryUri;

    public SpoonacularDao(Class<T> type) {
        properties = loadProperties("/api.properties");
        baseUri = properties.getProperty("api.spoonacular.url");
        searchMenuItemsString = properties.getProperty("api.spoonacular.menu.item.search.url");
        authenticationString = properties.getProperty("api.spoonacular.url.key");

        client = ClientBuilder.newClient();
        mapper = new ObjectMapper();

        this.type = type;
    }



    public void createMenuItemSearchURI(String query, int offsetForPaging, int numberOfResults) {
        String queryString = "&query=" + query + "&offset=" + offsetForPaging + "&number=" + numberOfResults;

        //Put it all together
        queryUri = baseUri + searchMenuItemsString + authenticationString + queryString;
    }

    public T searchSpoonacular() throws NullPointerException {
        if (queryUri.isEmpty() || queryUri.isBlank()) {
            throw new NullPointerException("Query URI is null. Please generate the query URI before searching.");
        } else {
            WebTarget target = client.target(queryUri);
            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
            return jsonToObject(response);
        }
    }

    private T jsonToObject(String responseJSON) {
        T result = null;
        try {
            result = mapper.readValue(responseJSON, type);
        } catch (JsonProcessingException jsonException) {
            log.error("JSON Processing exception when converting from JSON to a " + type + " object",
                    jsonException);
        }
        return result;
    }

}

