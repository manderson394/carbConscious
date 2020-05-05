package com.mattanderson.carbConscious.controller;

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
import java.util.*;

@WebServlet(
        name = "deleteFavorite",
        urlPatterns = { "/deleteFavorite" }
)
@Log4j2
public class deleteFavorite extends HttpServlet implements ControllerUtilities {

    private GenericDao<UserFavorite> favoriteDao;

    public void init() {
        favoriteDao = new GenericDao<>(UserFavorite.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loggedInUserName = request.getRemoteUser();
        User loggedInUser = getSessionUser(loggedInUserName);

        int favoriteId = Integer.parseInt(request.getParameter("rowFavoriteId"));

        UserFavorite deletedFavorite = favoriteDao.getById(favoriteId);

        log.debug("Deleting user favorite: {}", deletedFavorite);

        removeFavorite(deletedFavorite, loggedInUser);

        sendAjaxResponse(response);
    }

    private void removeFavorite(UserFavorite favoriteToRemove, User user) {
        Set<UserFavorite> allFavorites = user.getFavorites();
        List<UserFavorite> favoritesToUpdates = new ArrayList<>();

        int lineOfDeleted = favoriteToRemove.getLine();

        for (UserFavorite favorite : allFavorites) {
            int checkedLine = favorite.getLine();
            if (checkedLine > lineOfDeleted) {
                favorite.setLine(checkedLine - 1);
                favoritesToUpdates.add(favorite);
            }
        }

        favoriteDao.delete(favoriteToRemove);

        for (UserFavorite updateFavorite : favoritesToUpdates) {
            favoriteDao.saveOrUpdate(updateFavorite);
        }


    }

    private void sendAjaxResponse(HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();

        String successMessage = "Favorite has been removed.";

        writer.print(successMessage);
    }
}
