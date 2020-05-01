package com.mattanderson.carbConscious.controller;

import com.mattanderson.carbConscious.entity.Restaurant;
import com.mattanderson.carbConscious.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Forwards to caller to the JSP to create menu items.
 * @author Matt Anderson
 * @version 11
 */
@WebServlet(
        name = "viewMenuItemCreation",
        urlPatterns = { "/viewMenuItemCreation" }
)
public class ViewMenuItemCreation extends HttpServlet {

    private GenericDao<Restaurant> restaurantDao;

    public void init() {
        restaurantDao = new GenericDao<>(Restaurant.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Restaurant> availableRestaurants = restaurantDao.getAll();

        request.setAttribute("availableRestaurants", availableRestaurants);

        RequestDispatcher dispatcher = request.getRequestDispatcher("user/menuItemCreation.jsp");

        dispatcher.forward(request, response);
    }
}
