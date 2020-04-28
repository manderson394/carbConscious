package com.mattanderson.carbConscious.controller;


import com.mattanderson.carbConscious.entity.CarbohydratesEstimate;
import com.mattanderson.carbConscious.entity.MenuItem;
import com.mattanderson.carbConscious.entity.Outcome;
import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.persistence.GenericDao;
import com.mattanderson.carbConscious.util.ControllerUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Adds a carbohydrate estimate to a menu item identified by the caller.
 * @author Matt Anderson
 * @version 11
 */
@WebServlet(
        name = "addCarbohydrateEstimate",
        urlPatterns = { "/addCarbohydrateEstimate" }
)
public class AddCarbohydrateEstimate extends HttpServlet implements ControllerUtilities {

    private GenericDao<CarbohydratesEstimate> estimateDao;
    private GenericDao<User> userDao;
    private GenericDao<MenuItem> itemDao;

    public void init() {
        estimateDao = new GenericDao(CarbohydratesEstimate.class);
        userDao = new GenericDao(User.class);
        itemDao = new GenericDao(MenuItem.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String loggedInUserName = request.getRemoteUser();

        User loggedInUser = getSessionUser(loggedInUserName);

        int menuItemId = Integer.valueOf(request.getParameter("menuItemIdModal"));
        int carbGrams = Integer.valueOf(request.getParameter("carbGrams"));
        Outcome carbOutcome = Outcome.fromId(Integer.valueOf(request.getParameter("outcome")));

        MenuItem carbItem = itemDao.getById(menuItemId);

        CarbohydratesEstimate estimate = new CarbohydratesEstimate(carbGrams, carbItem, carbOutcome, loggedInUser);

        carbItem.addCarbohydratesEstimate(estimate);

        loggedInUser.addCarbohydratesEstimate(estimate);

        estimateDao.insert(estimate);
        itemDao.saveOrUpdate(carbItem);
        userDao.saveOrUpdate(loggedInUser);


    }
}
