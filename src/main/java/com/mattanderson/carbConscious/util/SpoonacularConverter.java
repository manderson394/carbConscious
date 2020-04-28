package com.mattanderson.carbConscious.util;

import com.mattanderson.carbConscious.entity.MenuAPI;
import com.mattanderson.carbConscious.entity.MenuItem;
import com.mattanderson.carbConscious.entity.Restaurant;
import com.mattanderson.carbConscious.persistence.GenericDao;
import com.spoonacular.entity.SpoonacularMenuItem;

import java.util.List;

public class SpoonacularConverter {

    private GenericDao<Restaurant> restaurantDao;
    private MenuAPI menuAPI;

    public SpoonacularConverter() {
        GenericDao<MenuAPI> menuApiDao = new GenericDao<>(MenuAPI.class);
        menuAPI = menuApiDao.getById(1);
    }

    public MenuItem toMenuItem(SpoonacularMenuItem spoonacularMenuItem) {
        restaurantDao = new GenericDao<>(Restaurant.class);
        List<Restaurant> restaurants = restaurantDao.getByPropertyLike("name", spoonacularMenuItem.getRestaurantChain());
        Restaurant restaurant = null;
        if (restaurants.size() == 1) {
            restaurant = restaurants.get(0);
        } else {
            restaurant = getNewChainRestaurant(spoonacularMenuItem);
        }
        MenuItem menuItem =
                new MenuItem(spoonacularMenuItem.getTitle(), "", menuAPI, spoonacularMenuItem.getId(), restaurant);
        return menuItem;
    }

    private Restaurant getNewChainRestaurant(SpoonacularMenuItem spoonacularItem) {
        Restaurant generatedRestaurant = new Restaurant(spoonacularItem.getRestaurantChain(), menuAPI);
        restaurantDao.insert(generatedRestaurant);
        return generatedRestaurant;
    }
}
