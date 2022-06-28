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
import java.util.List;

public class FileController extends HttpServlet {
    private final FileService fileService = new FileService();
    private final EventService eventService = new EventService();
    private final UserService userService = new UserService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("filename");
        String filePath = request.getParameter("filepath");
        Long userId = Long.valueOf(request.getParameter("userId"));
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

        File file = fileService.saveNewFile(fileName, filePath);
        eventService.saveCreated(file, user);

        request.setAttribute("file", file);
        request.getRequestDispatcher("view/file.jsp").forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        fileService.update(file, fileName, filePath);
        eventService.saveUpdated(file, user);

        request.setAttribute("file", file);
        request.getRequestDispatcher("view/file.jsp").forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        File file = fileService.getById(id);
        if (file == null) {
            request.getRequestDispatcher("view/fileNotFound.jsp").forward(request, response);
            return;
        }

        fileService.delete(file);
        request.setAttribute("file", file);
        request.getRequestDispatcher("view/fileDeleted.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            Long id = Long.valueOf(request.getParameter("id"));
            File file = fileService.getById(id);
            if (file == null) {
                request.getRequestDispatcher("view/fileNotFound.jsp").forward(request, response);
                return;
            }

            request.setAttribute("file", file);
            request.getRequestDispatcher("view/file.jsp").forward(request, response);
        } else {
            List<File> files = fileService.getAll();
            request.setAttribute("filesList", files);
            request.getRequestDispatcher("view/filesList.jsp").forward(request, response);
        }
    }
}
