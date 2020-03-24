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
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "designateView",
        urlPatterns = { "/designateView" }
)
@Log4j2
public class DesignateView extends HttpServlet {

    private String searchType;
    private String searchInput;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        searchType = request.getParameter("searchType");
        searchInput = request.getParameter("searchInput");
        log.debug("Search Type is : " + searchType);
        if (searchType.equals("restaurant") || searchType.equals("restaurantLocation")) {
            List<Restaurant> restaurants = doRestaurantSearch();
            dispatchRestaurantRequest(restaurants, request, response);
        } else if (searchType.equals("menuItem") || searchType.equals("menuItemLocation")) {
            List<MenuItem> menuItems = doMenuItemSearch();
            dispatchMenuItemRequest(menuItems, request, response);
        } else {
            request.setAttribute("searchError", "Please try again...");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    private List<Restaurant> doRestaurantSearch() {
        GenericDao<Restaurant> restaurantGenericDao = new GenericDao(Restaurant.class);
        if (searchType.equals("restaurant")) {
            return executeRestaurantSearch(restaurantGenericDao);
        } else if (searchType.equals("restaurantLocation")) {
            return executeRestaurantLocationSearch(restaurantGenericDao);
        } else {
            return new ArrayList<Restaurant>();
        }
    }

    private List<MenuItem> doMenuItemSearch() {
        GenericDao<MenuItem> menuItemGenericDao = new GenericDao(MenuItem.class);
        if (searchType.equals("menuItem")) {
            return executeMenuItemSearch(menuItemGenericDao);
        } else if (searchType.equals("menuItemLocation")) {
            return executeMenuItemLocationSearch(menuItemGenericDao);
        } else {
            return new ArrayList<MenuItem>();
        }
    }

    private List<Restaurant> executeRestaurantSearch(GenericDao<Restaurant> restaurantDao) {
        return restaurantDao.getByPropertyLike("name", searchInput);
    }

    private List<Restaurant> executeRestaurantLocationSearch(GenericDao<Restaurant> restaurantDao) {
        return restaurantDao.getByPropertyLike("", searchInput);
        //TODO Build Support for Restaurant Location search
    }

    private List<MenuItem> executeMenuItemSearch(GenericDao<MenuItem> menuItemDao) {
        return menuItemDao.getByPropertyLike("name", searchInput);
    }

    private List<MenuItem> executeMenuItemLocationSearch(GenericDao<MenuItem> menuItemDao) {
        return menuItemDao.getByPropertyLike("", searchInput);
        //TODO Build Support for MenuItem Location Search
    }

    private void dispatchRestaurantRequest(List<Restaurant> restaurantList, HttpServletRequest req,
                                           HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("restaurantResults", restaurantList);

        log.debug("Sending back Restaurant(s)..." + restaurantList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewRestaurants.jsp");
        dispatcher.forward(req, resp);
    }

    private void dispatchMenuItemRequest(List<MenuItem> menuItemList, HttpServletRequest req,
                                         HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("menuItemResults", menuItemList);

        log.debug("Sending back MenuItem(s)..." + menuItemList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewMenuItems.jsp");
        dispatcher.forward(req, resp);
    }
}
