package com.mattanderson.carbConscious.controller;

import com.mattanderson.carbConscious.entity.MenuItem;
import com.mattanderson.carbConscious.entity.Restaurant;
import com.mattanderson.carbConscious.persistence.GenericDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "createMenuItem",
        urlPatterns = { "/createMenuItem" }
)
public class CreateMenuItem extends HttpServlet {

    private GenericDao<MenuItem> menuItemDao;
    private GenericDao<Restaurant> restaurantDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        int restaurantId = Integer.valueOf(request.getParameter("menuItemRestaurant"));
        String itemName = request.getParameter("menuItemName");
        String description = request.getParameter("menuItemDescription");

        Restaurant restaurant = restaurantDao.getById(restaurantId);

        MenuItem newItem = new MenuItem(itemName, description, restaurant);

        menuItemDao.insert(newItem);
    }
}
