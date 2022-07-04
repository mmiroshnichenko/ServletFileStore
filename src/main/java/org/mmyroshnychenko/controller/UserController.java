package org.mmyroshnychenko.controller;

import org.mmyroshnychenko.model.User;
import org.mmyroshnychenko.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserController extends HttpServlet {
    private final UserService userService = new UserService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User existedUser = userService.getByUsername(username);
        if (existedUser != null) {
            request.setAttribute("user", existedUser);
            request.getRequestDispatcher("view/userExists.jsp").forward(request, response);
            return;
        }
        User user = userService.saveNewUser(request.getParameter("username"));
        request.setAttribute("user", user);
        request.getRequestDispatcher("view/user.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            Long id = Long.valueOf(request.getParameter("id"));
            User user = userService.getById(id);
            if (user == null) {
                request.getRequestDispatcher("view/userNotFound.jsp").forward(request, response);
                return;
            }

            request.setAttribute("user", user);
            request.getRequestDispatcher("view/user.jsp").forward(request, response);
        } else {
            List<User> users = userService.getAll();
            request.setAttribute("usersList", users);
            request.getRequestDispatcher("view/userList.jsp").forward(request, response);
        }
    }
}
