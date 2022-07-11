package org.mmyroshnychenko.controller;

import org.mmyroshnychenko.model.File;
import org.mmyroshnychenko.model.User;
import org.mmyroshnychenko.service.EventService;
import org.mmyroshnychenko.service.FileService;
import org.mmyroshnychenko.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FileUpdateController extends HttpServlet {
    private final FileService fileService = new FileService();
    private final EventService eventService = new EventService();
    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("newFilename");
        String filePath = request.getParameter("newFilepath");
        Long userId = Long.valueOf(request.getParameter("userId"));
        Long id = Long.valueOf(request.getParameter("id"));
        File existsFile = fileService.getByNameAndPath(fileName, filePath);
        if (existsFile != null) {
            request.setAttribute("file", existsFile);
            request.getRequestDispatcher("view/fileExists.jsp").forward(request, response);
            return;
        }
        User user = userService.getById(userId);
        if (user == null) {
            request.getRequestDispatcher("view/userNotFound.jsp").forward(request, response);
            return;
        }
        File file = fileService.getById(id);
        if (file == null) {
            request.getRequestDispatcher("view/fileNotFound.jsp").forward(request, response);
            return;
        }

        fileService.updateFile(file, fileName, filePath);
        eventService.saveUpdated(file, user);

        request.setAttribute("file", file);
        request.getRequestDispatcher("view/file.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
