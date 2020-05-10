package com.mattanderson.carbConscious.controller;

import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.persistence.GenericDao;
import com.mattanderson.carbConscious.util.ControllerUtilities;
import com.mattanderson.carbConscious.util.GenericValidator;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Updates a user based on the changes to their profile identified by the caller.
 * @author Matt Anderson
 * @version 11
 */
@WebServlet(
        name = "updateUser",
        urlPatterns = { "/updateUser" }
)
@Log4j2
public class UpdateUser extends HttpServlet implements ControllerUtilities {

    private GenericDao<User> userDao;
    private Map<String, String> errors;
    private User loggedInUser;
    private String oldPassword;
    private String newPasswordOne;
    private String newPasswordTwo;
    private String successString = "";

    public void init() {
        userDao = new GenericDao<>(User.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String loggedInUserName = request.getRemoteUser();
        log.debug("request.getRemoveUser() = {}", loggedInUserName);

        loggedInUser = getSessionUser(loggedInUserName);
        oldPassword = request.getParameter("passwordCurrent");

        newPasswordOne = request.getParameter("newPasswordFirst");
        newPasswordTwo = request.getParameter("newPasswordSecond");

        log.debug("oldPassword: {}", oldPassword);
        log.debug("newPasswordOne: {}", newPasswordOne);
        log.debug("newPasswordTwo: {}", newPasswordTwo);

        errors = new HashMap<String, String>();

        actOnName(request);
        actOnUserName(request);

        validateProfileForm();

        actOnPassword(request);

        log.debug("Errors: {}" , errors);

        if (errors.isEmpty()) {

            userDao.saveOrUpdate(loggedInUser);
            log.info("User ({}) has been updated.", loggedInUser.getEmail());

            request.getSession().setAttribute("userFirstName",loggedInUser.getFirstName());

            request.setAttribute("successModal", true);
            request.setAttribute("successModalMessage", successString);
        } else {
            log.debug("Unable to update user ({}); encountered errors: {}", loggedInUser.getEmail() ,errors);
            request.setAttribute("profileErrorMap", errors);
        }

        request.setAttribute("userName", loggedInUser.getUserName());
        request.setAttribute("firstName", loggedInUser.getFirstName());
        request.setAttribute("lastName", loggedInUser.getLastName());
        request.setAttribute("email", loggedInUser.getEmail());

        RequestDispatcher dispatcher = request.getRequestDispatcher("user/userProfile.jsp");
        dispatcher.forward(request, response);
    }

    private void validateProfileForm() {
        GenericValidator<User> validator = new GenericValidator<>(User.class);

        errors = validator.validate(loggedInUser);
    }

    private void actOnName(HttpServletRequest req) {
        String reqFirstName = req.getParameter("firstName");

        String reqLastName = req.getParameter("lastName");

        if (!reqFirstName.equals(loggedInUser.getFirstName())) {
            loggedInUser.setFirstName(reqFirstName);
            log.info("Updating first name for user: {}", loggedInUser.getEmail());
            successString += "Your first name has been updated.";
        }
        if (!reqLastName.equals(loggedInUser.getLastName())) {
            loggedInUser.setLastName(reqLastName);
            log.info("Updating last name for user: {}", loggedInUser.getEmail());
            successString += "Your last name has been updated. <br>";
        }
    }

    private void actOnUserName(HttpServletRequest req) {
        String reqUserName = req.getParameter("userName");

        if (!reqUserName.equals(loggedInUser.getUserName())) {

            List<User> existingUsers = userDao.getByPropertyEqual("userName", reqUserName);

            if (existingUsers.isEmpty()) {
                loggedInUser.setUserName(reqUserName);
                log.info("Updating username for user: {}", loggedInUser.getEmail());
                successString += "Your username has been updated. <br>";
            } else {
                errors.put("userName", "Username already in use. Choose a different username.");
            }
        }
    }

    private void actOnPassword(HttpServletRequest req) {
        if (oldPassword.equals(loggedInUser.getPassword())) {

            if (!newPasswordOne.isEmpty()) {

                if (!newPasswordOne.equals(newPasswordTwo)) {
                    errors.put("password", "New password first and second entries don't match.");
                } else {
                    loggedInUser.setPassword(newPasswordOne);
                    log.info("Updating password for user: {}", loggedInUser.getEmail());
                    successString += "Your password has been updated. <br>";
                }
            }

        } else if (!oldPassword.isEmpty()){
            errors.put("password", "The entered password in the current password field does not match your password.");
        }
    }
}
