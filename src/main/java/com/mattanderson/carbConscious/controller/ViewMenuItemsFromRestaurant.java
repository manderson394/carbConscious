package com.mattanderson.carbConscious.controller;


import com.mattanderson.carbConscious.entity.MenuItem;
import com.mattanderson.carbConscious.entity.Restaurant;
import com.mattanderson.carbConscious.persistence.GenericDao;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "viewMenuItemsFromRestaurant",
        urlPatterns = { "/viewMenuItemsFromRestaurant" }
)
@Log4j2
public class ViewMenuItemsFromRestaurant extends HttpServlet {

    private GenericDao<MenuItem> menuItemsDao;
    private GenericDao<Restaurant> restaurantDao;

    public void init() {
        menuItemsDao = new GenericDao<>(MenuItem.class);
        restaurantDao = new GenericDao<>(Restaurant.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int restaurantId = Integer.valueOf(request.getParameter("restaurant"));
        log.debug("Searching for Restaurant with ID, {}", restaurantId);
        Restaurant searchRestaurant = restaurantDao.getById(restaurantId);

        log.debug("Restaurant found: {}", searchRestaurant);
        List<MenuItem> resultList = menuItemsDao.getByPropertyEqual("parentRestaurant", searchRestaurant);
        request.setAttribute("menuItemResults", resultList);
        log.debug("Results: {}", resultList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewMenuItems.jsp");
        dispatcher.forward(request, response);
    }
}
