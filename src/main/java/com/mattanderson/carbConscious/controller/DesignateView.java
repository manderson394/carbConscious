package com.mattanderson.carbConscious.controller;


import com.mattanderson.carbConscious.entity.MenuAPI;
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
import java.util.Set;

@WebServlet(
        name = "designateView",
        urlPatterns = { "/designateView" }
)
@Log4j2
public class DesignateView extends HttpServlet {

    private String searchType;
    private String searchInput;
    private GenericDao<MenuItem> itemDao;
    private GenericDao<Restaurant> restaurantDao;

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
        restaurantDao = new GenericDao(Restaurant.class);
        if (searchType.equals("restaurant")) {
            return executeRestaurantSearch();
        } else if (searchType.equals("restaurantLocation")) {
            return executeRestaurantLocationSearch();
        } else {
            return new ArrayList<Restaurant>();
        }
    }

    private List<MenuItem> doMenuItemSearch() {
        itemDao = new GenericDao(MenuItem.class);
        if (searchType.equals("menuItem")) {
            return executeMenuItemSearch();
        } else if (searchType.equals("menuItemLocation")) {
            return executeMenuItemLocationSearch();
        } else {
            return new ArrayList<MenuItem>();
        }
    }

    private List<Restaurant> executeRestaurantSearch() {
        return restaurantDao.getByPropertyLike("name", searchInput);
    }

    private List<Restaurant> executeRestaurantLocationSearch() {
        return restaurantDao.getByPropertyEqual("zipCode", searchInput);
    }

    private List<MenuItem> executeMenuItemSearch() {
        return itemDao.getByPropertyLike("name", searchInput);
    }

    private List<MenuItem> executeMenuItemLocationSearch() {
        restaurantDao = new GenericDao<>(Restaurant.class);
        List<Restaurant> restaurantList = restaurantDao.getByPropertyEqual("zipCode", searchInput);
        List<MenuItem> itemResults = new ArrayList<>();
        for (Restaurant rest : restaurantList) {
            Set<MenuItem> menuItemSet = rest.getMenuItems();
            for (MenuItem item : menuItemSet) {
                itemResults.add(item);
            }
        }

        return itemResults;
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
