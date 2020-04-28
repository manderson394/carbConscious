package com.mattanderson.carbConscious.controller;

import com.mattanderson.carbConscious.entity.Restaurant;
import com.mattanderson.carbConscious.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Creates a restaurant.
 * @author Matt Anderson
 * @version 11
 */
@WebServlet(
        name = "createRestaurant",
        urlPatterns = { "/createRestaurant" }
)
public class CreateRestaurant extends HttpServlet {

    private GenericDao<Restaurant> restaurantDao;

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

        restaurantDao.insert(newRestaurant);
    }
}
