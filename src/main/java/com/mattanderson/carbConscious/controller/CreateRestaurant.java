package com.mattanderson.carbConscious.controller;

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
import java.util.Map;

/**
 * Creates a restaurant.
 * @author Matt Anderson
 * @version 11
 */
@WebServlet(
        name = "createRestaurant",
        urlPatterns = { "/createRestaurant" }
)
@Log4j2
public class CreateRestaurant extends HttpServlet {

    private GenericDao<Restaurant> restaurantDao;
    private Map<String, String> errors;

    public void init() {
        restaurantDao = new GenericDao<>(Restaurant.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String restaurantName = request.getParameter("restaurantName");
        String restaurantStreetAddress = request.getParameter("restaurantStreetAddress");
        String restaurantState = request.getParameter("restaurantState");
        String restaurantZipCode = request.getParameter("restaurantZipCode");
        String restaurantPhoneNumber = request.getParameter("restaurantPhoneNumber");

        Restaurant newRestaurant = new Restaurant(restaurantName, restaurantStreetAddress, restaurantState, restaurantZipCode, restaurantPhoneNumber);

        processRestaurant(newRestaurant);

        if (errors.isEmpty()) {
            log.debug("Adding new restaurant: {}", newRestaurant);

            restaurantDao.insert(newRestaurant);

            request.setAttribute("successModal", true);
            request.setAttribute("successModalMessage", "Restaurant created.");
        } else {
            log.debug("Unable to create restaurant; errors found: {}", errors);
            request.setAttribute("restaurantErrors", errors);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("user/restaurantCreation.jsp");
        dispatcher.forward(request, response);

    }

    private void processRestaurant(Restaurant restaurant) {
        GenericValidator<Restaurant> validator = new GenericValidator<>(Restaurant.class);

        errors = validator.validate(restaurant);
    }
}
