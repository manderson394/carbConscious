package com.mattanderson.carbConscious.controller;

import com.mattanderson.carbConscious.entity.MenuItem;
import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.entity.UserFavorite;
import com.mattanderson.carbConscious.persistence.GenericDao;
import com.mattanderson.carbConscious.util.ControllerUtilities;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * Adds a favorite for the user specified by the caller.
 * @author Matt Anderson
 * @version 11
 */
@WebServlet(
        name = "addFavorite",
        urlPatterns = { "/addFavorite" }
)
@Log4j2
public class AddFavorite extends HttpServlet implements ControllerUtilities {

    private GenericDao<User> userDao;
    private GenericDao<UserFavorite> favoriteDao;
    private GenericDao<MenuItem> itemDao;

    public void init() {
        userDao = new GenericDao<>(User.class);
        favoriteDao = new GenericDao<>(UserFavorite.class);
        itemDao = new GenericDao<>(MenuItem.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loggedInUserName = request.getRemoteUser();

        User loggedInUser = getSessionUser(loggedInUserName);

        int menuItemId = Integer.parseInt(request.getParameter("rowMenuItemId"));

        MenuItem menuItem = itemDao.getById(menuItemId);

        UserFavorite newFavorite = createUserFavorite(menuItem, loggedInUser);

        log.debug("About to save new favorite: {}", newFavorite);

        saveFavorite(newFavorite, loggedInUser);

        sendAjaxResponse(response);
    }

    private UserFavorite createUserFavorite(MenuItem item, User user) {
        Set<UserFavorite> favoriteSet = user.getFavorites();
        if (favoriteSet.contains(item)) {
            return new UserFavorite(0, user, item);
        }

        if (favoriteSet.size() < 1) {
            return new UserFavorite(1, user, item);
        } else {
            UserFavorite lastLineFavorite = null;
            int count = 0;
            for (UserFavorite fav : favoriteSet) {
                if (count < 1) {
                    lastLineFavorite = fav;
                } else {
                    if (fav.getLine() > lastLineFavorite.getLine()) {
                        lastLineFavorite = fav;
                    }
                }
                count++;
            }
            int endLine = lastLineFavorite.getLine() + 1;
            return new UserFavorite(endLine, user, item);
        }
    }

    private void saveFavorite(UserFavorite favorite, User user) {
        if (favorite.getLine() != 0) {
            user.addFavorite(favorite);
            favoriteDao.insert(favorite);
            userDao.saveOrUpdate(user);
        }
    }

    private void sendAjaxResponse(HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();

        String successMessage = "Favorite has been added.";

        writer.print(successMessage);
    }
}
