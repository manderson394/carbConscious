package com.mattanderson.carbConscious.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Forwards the caller to the JSP for viewing restaurants.
 * @author Matt Anderson
 * @version 11
 */
@WebServlet(
        name = "viewRestaurantCreation",
        urlPatterns = { "/viewRestaurantCreation" }
)
public class ViewRestaurantCreation extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("user/restaurantCreation.jsp");

        dispatcher.forward(request, response);
    }
}
