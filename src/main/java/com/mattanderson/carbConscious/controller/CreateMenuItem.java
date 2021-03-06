package com.mattanderson.carbConscious.controller;

import com.mattanderson.carbConscious.entity.MenuItem;
import com.mattanderson.carbConscious.entity.Restaurant;
import com.mattanderson.carbConscious.persistence.GenericDao;
import com.mattanderson.carbConscious.util.GenericValidator;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
    private Map<String, String> errors;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int restaurantId = Integer.parseInt(request.getParameter("menuItemRestaurant"));
        String itemName = request.getParameter("menuItemName");
        String description = request.getParameter("menuItemDescription");

        restaurantDao = new GenericDao<>(Restaurant.class);
        Restaurant restaurant = restaurantDao.getById(restaurantId);

        MenuItem newItem = new MenuItem(itemName, description, restaurant);

        processMenuItem(newItem);

        if (errors.isEmpty()) {
            log.debug("About to save new menu item: {}", newItem);

            restaurant.addMenuItem(newItem);

            menuItemDao = new GenericDao<>(MenuItem.class);
            menuItemDao.insert(newItem);
            restaurantDao.saveOrUpdate(restaurant);

            request.setAttribute("successModal", true);
            request.setAttribute("successModalMessage", "Menu item created.");
        } else {
            log.debug("Unable to save new menu item; encountered errors: {}", errors);
            request.setAttribute("itemErrorMap", errors);
            request.setAttribute("restaurantChosen", restaurant.getId());
        }

        List<Restaurant> availableRestaurants = restaurantDao.getAll();
        request.setAttribute("availableRestaurants", availableRestaurants);

        RequestDispatcher dispatcher = request.getRequestDispatcher("user/menuItemCreation.jsp");
        dispatcher.forward(request, response);
    }

    private void processMenuItem(MenuItem itemToValidate) {
        GenericValidator<MenuItem> validator = new GenericValidator<>(MenuItem.class);

        errors = validator.validate(itemToValidate);
    }
}
