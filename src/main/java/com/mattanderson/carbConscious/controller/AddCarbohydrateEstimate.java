package com.mattanderson.carbConscious.controller;


import com.mattanderson.carbConscious.entity.CarbohydratesEstimate;
import com.mattanderson.carbConscious.entity.MenuItem;
import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.persistence.GenericDao;
import com.mattanderson.carbConscious.util.ControllerUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "addCarbohydrateEstimate",
        urlPatterns = { "/addCarbohydrateEstimate" }
)
public class AddCarbohydrateEstimate extends HttpServlet implements ControllerUtilities {

    private GenericDao<CarbohydratesEstimate> estimateDao;
    private GenericDao<User> userDao;
    private GenericDao<MenuItem> itemDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }
}
