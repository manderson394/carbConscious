package com.mattanderson.carbConscious.controller;

import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.util.ControllerUtilities;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Forwards the user to the JSP to view favorites after data manipulation.
 * @author Matt Anderson
 * @version 11
 */
@WebServlet(
        name = "viewProfile",
        urlPatterns = { "/viewProfile" }
)
public class ViewProfile extends HttpServlet implements ControllerUtilities {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loggedInUserName = request.getRemoteUser();

        User loggedInUser = getSessionUser(loggedInUserName);

        request.setAttribute("userName", loggedInUserName);
        request.setAttribute("firstName", loggedInUser.getFirstName());
        request.setAttribute("lastName", loggedInUser.getLastName());
        request.setAttribute("email", loggedInUser.getEmail());

        RequestDispatcher dispatcher = request.getRequestDispatcher("user/userProfile.jsp");
        dispatcher.forward(request, response);

    }
}
