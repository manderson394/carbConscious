package com.mattanderson.carbConscious.controller;


import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Creates a new user. Intended for use as a sign up action for a user.
 * @author Matt Anderson
 * @version 11
 */
@WebServlet(
        name = "createNewUser",
        urlPatterns = { "/createNewUser" }
)
public class CreateNewUser extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User signedUpUser = new User(firstName, lastName, userName, email, password);

        processUser(signedUpUser);

        HttpSession session = request.getSession();
        session.setAttribute("userFirstName", firstName);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    private void processUser(User user) {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        userDao.insert(user);
    }
}
