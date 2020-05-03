package com.mattanderson.carbConscious.controller;


import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.entity.UserRole;
import com.mattanderson.carbConscious.persistence.GenericDao;
import com.mattanderson.carbConscious.util.GenericValidator;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Creates a new user. Intended for use as a sign up action for a user.
 *
 * @author Matt Anderson
 * @version 11
 */
@WebServlet(
        name = "createNewUser",
        urlPatterns = { "/createNewUser" }
)
@Log4j2
public class CreateNewUser extends HttpServlet {

    private Map<String, String> errors = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String userName = request.getParameter("userName").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("passwordFirst").trim();

        User signedUpUser = new User(firstName, lastName, userName, email, password);

        validateUser(signedUpUser);

        if (errors.isEmpty()) {
            log.info("Creating a new user.");
            processUser(signedUpUser);

            HttpSession session = request.getSession();
            session.setAttribute("userFirstName", firstName);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        } else {
            log.debug("Errors found: {}", errors);
            request.setAttribute("errorMap", errors);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/signUp.jsp");
            dispatcher.forward(request, response);
        }


    }

    private void processUser(User user) {
        UserRole role = new UserRole("User", user);

        user.addRole(role);

        //Do some logging, but don't log the password
        log.debug("Adding new user: User={firstName={}, lastName={}, userName={}, email={}, roles={}",
                user.getFirstName(), user.getLastName(), user.getUserName(), user.getEmail(), user.getRoles());

        GenericDao<User> userDao = new GenericDao<>(User.class);
        userDao.insert(user);

        GenericDao<UserRole> roleDao = new GenericDao<>(UserRole.class);
        roleDao.saveOrUpdate(role);
    }

    private void validateUser(User testUser) {
        GenericValidator<User> validator = new GenericValidator<>(User.class);

        errors = validator.validate(testUser);
    }
}
