package org.mmyroshnychenko.controller;

import org.mmyroshnychenko.model.User;
import org.mmyroshnychenko.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserUpdateController extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("newUsername");
        Long id = Long.valueOf(request.getParameter("id"));
        User existedUser = userService.getByUsername(username);
        if (existedUser != null) {
            request.setAttribute("user", existedUser);
            request.getRequestDispatcher("view/userExists.jsp").forward(request, response);
            return;
        }

        User user = userService.getById(id);
        if (user == null) {
            request.getRequestDispatcher("view/userNotFound.jsp").forward(request, response);
            return;
        }

        userService.updateUser(user, username);
        request.setAttribute("user", user);
        request.getRequestDispatcher("view/user.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
