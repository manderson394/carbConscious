package com.mattanderson.carbConscious.controller;

import com.mattanderson.carbConscious.entity.MenuItem;
import com.mattanderson.carbConscious.entity.Restaurant;
import com.mattanderson.carbConscious.persistence.GenericDao;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Creates a menu item.
 * @author Matt Anderson
 * @version 11
 */
@WebServlet(
        name = "createMenuItem",
        urlPatterns = { "/createMenuItem" }
)
@Log4j2
public class CreateMenuItem extends HttpServlet {

    private GenericDao<MenuItem> menuItemDao;
    private GenericDao<Restaurant> restaurantDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int restaurantId = Integer.valueOf(request.getParameter("menuItemRestaurant"));
        String itemName = request.getParameter("menuItemName");
        String description = request.getParameter("menuItemDescription");

        Restaurant restaurant = restaurantDao.getById(restaurantId);

        MenuItem newItem = new MenuItem(itemName, description, restaurant);

        log.debug("About to save new menu item: {}", newItem);

        restaurant.addMenuItem(newItem);

        menuItemDao.insert(newItem);
        restaurantDao.saveOrUpdate(restaurant);
    }
}
