package com.mattanderson.carbConscious.controller;


import com.mattanderson.carbConscious.entity.CarbohydratesEstimate;
import com.mattanderson.carbConscious.entity.MenuItem;
import com.mattanderson.carbConscious.entity.Outcome;
import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.persistence.GenericDao;
import com.mattanderson.carbConscious.util.ControllerUtilities;
import lombok.extern.log4j.Log4j2;

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
@Log4j2
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

        int menuItemId = Integer.parseInt(request.getParameter("menuItemIdModal"));
        int carbGrams = Integer.parseInt(request.getParameter("carbGrams"));
        Outcome carbOutcome = Outcome.fromId(Integer.parseInt(request.getParameter("outcome")));

        MenuItem carbItem = itemDao.getById(menuItemId);

        CarbohydratesEstimate estimate = new CarbohydratesEstimate(carbGrams, carbItem, carbOutcome, loggedInUser);

        log.debug("Creating a new carbohydrate estimate: {}", estimate);

        carbItem.addCarbohydratesEstimate(estimate);

        loggedInUser.addCarbohydratesEstimate(estimate);

        estimateDao.insert(estimate);
        itemDao.saveOrUpdate(carbItem);
        userDao.saveOrUpdate(loggedInUser);


    }
}
