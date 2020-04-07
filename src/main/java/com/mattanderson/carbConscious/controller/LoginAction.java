package com.mattanderson.carbConscious.controller;

import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.persistence.GenericDao;
import com.mattanderson.carbConscious.util.ControllerUtilities;
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

/**
 * Forwards a logged in user.
 * @author Matt Anderson
 * @version 11
 */
@WebServlet(
        name = "login",
        urlPatterns = { "/login" }
)

@Log4j2
public class LoginAction extends HttpServlet implements ControllerUtilities {

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
}
