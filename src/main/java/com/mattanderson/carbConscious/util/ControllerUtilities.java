package com.mattanderson.carbConscious.util;

import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.persistence.GenericDao;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Defines shared methods for classes within the controller package.
 * @author Matt Anderon
 * @version 11
 */
public interface ControllerUtilities {

    /**
     * Gets the user from the session.
     *
     * @param userName the user name
     * @return the session user
     */
    default User getSessionUser(String userName) {
        //Create a logger
        Logger log = LogManager.getLogger(ControllerUtilities.class);

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
