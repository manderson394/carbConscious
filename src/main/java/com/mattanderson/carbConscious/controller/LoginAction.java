package com.mattanderson.carbConscious.controller;

import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.persistence.GenericDao;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "login",
        urlPatterns = { "/login" }
)

@Log4j2
public class LoginAction extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Send some logging data
        String loggedInUserName = request.getRemoteUser();
        log.info("The login user: " + loggedInUserName);

        //Set the user first name in the session
        User loggedInUser = getSessionUser(loggedInUserName);

        HttpSession session = request.getSession();
        session.setAttribute("userFirstName",loggedInUser.getFirstName());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    private User getSessionUser(String userName) {
        //Look up the user
        GenericDao<User> userDao = new GenericDao<User>(User.class);
        List<User> users = userDao.getByPropertyEqual("userName", userName);

        //This shouldn't ever happen, but if it does, make sure we know about it
        if (users.size() > 1) {
            log.error("DATA CORRUPTION: More than one user in the USERS table with a user_name of: " + userName);
        }

        User loggedInUser = users.get(0);

        return loggedInUser;
    }
}
