package org.mmyroshnychenko.controller;

import org.mmyroshnychenko.model.User;
import org.mmyroshnychenko.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteController extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        User user = userService.getById(id);
        if (user == null) {
            request.getRequestDispatcher("view/userNotFound.jsp").forward(request, response);
            return;
        }

        userService.deleteUser(user);
        request.setAttribute("user", user);
        request.getRequestDispatcher("view/userDeleted.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
