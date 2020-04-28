package com.mattanderson.carbConscious.controller;

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
 * Updates a user based on the changes to their profile identified by the caller.
 * @author Matt Anderson
 * @version 11
 */
@WebServlet(
        name = "updateUser",
        urlPatterns = { "/updateUser" }
)
public class UpdateUser extends HttpServlet implements ControllerUtilities {

    private GenericDao<User> userDao;

    public void init() {
        userDao = new GenericDao<>(User.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String loggedInUserName = request.getRemoteUser();

        User loggedInUser = getSessionUser(loggedInUserName);

        actOnName(request, loggedInUser);

        actOnPassword(request, loggedInUser);
    }

    private void actOnName(HttpServletRequest req, User user) {
        String reqFirstName = req.getParameter("firstName");

        String reqLastName = req.getParameter("lastName");

        if (!reqFirstName.equals(user.getFirstName())) {
            user.setFirstName(reqFirstName);
            userDao.saveOrUpdate(user);
        }
        if (!reqLastName.equals(user.getLastName())) {
            user.setLastName(reqLastName);
            userDao.saveOrUpdate(user);
        }
    }

    private void actOnPassword(HttpServletRequest req, User user) {

        String newPassword = req.getParameter("passwordCurrent");

        String oldPasswordFirst = req.getParameter("oldPasswordFirst");

        String oldPasswordSecond = req.getParameter("oldPasswordSecond");

        if ((!newPassword.equals(user.getPassword()))
                && (oldPasswordFirst.equals(oldPasswordSecond))
                && oldPasswordFirst.equals(user.getPassword())) {
            user.setPassword(newPassword);
            userDao.saveOrUpdate(user);
        }
    }
}
