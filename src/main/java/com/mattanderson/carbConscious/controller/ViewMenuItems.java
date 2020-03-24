package com.mattanderson.carbConscious.controller;


import com.mattanderson.carbConscious.entity.MenuItem;
import com.mattanderson.carbConscious.persistence.GenericDao;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//TODO Consider removing this class -- may be unnecessary

@WebServlet(
        name = "viewMenuItems",
        urlPatterns = { "/viewMenuItems" }
)
@Log4j2
public class ViewMenuItems extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao<MenuItem> menuItems = new GenericDao<>(MenuItem.class);
    }
}
