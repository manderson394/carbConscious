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

@WebServlet(
        name = "createNewUser",
        urlPatterns = { "/createNewUser" }
)
public class CreateNewUser extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
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
