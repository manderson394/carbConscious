package com.mattanderson.carbConscious.controller;


import com.mattanderson.carbConscious.entity.User;
import com.mattanderson.carbConscious.entity.UserFavorite;
import com.mattanderson.carbConscious.persistence.GenericDao;
import com.mattanderson.carbConscious.util.ControllerUtilities;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Forwards a user to to a page to view their favorites.
 *
 * @author Matt Anderson
 * @version 11
 */
@WebServlet(
        name = "viewFavorites",
        urlPatterns = { "/viewFavorites" }
)
public class ViewFavorites extends HttpServlet implements ControllerUtilities {

    private Map<Integer, UserFavorite> favoritesMap;

    public void init() {
        favoritesMap = new TreeMap<Integer, UserFavorite>();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String loggedInUserName = request.getRemoteUser();

        User loggedInUser = getSessionUser(loggedInUserName);

        getUserFavorites(loggedInUser);

        request.setAttribute("favoritesResults", favoritesMap);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewFavorites.jsp");
        dispatcher.forward(request, response);
    }

    private void getUserFavorites(User user) {
        List<UserFavorite> favorites = getFavoritesFromDao(user);

        for (UserFavorite fav : favorites) {
            int lineNumber = fav.getLine();
            favoritesMap.put(lineNumber, fav);
        }
    }

    private List<UserFavorite> getFavoritesFromDao(User user) {
        GenericDao<UserFavorite> favoriteDao = new GenericDao<>(UserFavorite.class);
        List<UserFavorite> favorites = favoriteDao.getByPropertyEqual("user", user);
        return favorites;
    }
}
