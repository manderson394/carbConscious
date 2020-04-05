package com.mattanderson.carbConscious.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Directs the user to the sign up page.
 * @author Matt Anderson
 * @version 11
 */
@WebServlet(
        name = "signUp",
        urlPatterns = { "/signUp" }
)
public class SignUpAction extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/signUp.jsp");
        dispatcher.forward(request, response);
    }
}
