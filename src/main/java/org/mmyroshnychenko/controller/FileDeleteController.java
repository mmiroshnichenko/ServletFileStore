package org.mmyroshnychenko.controller;

import org.mmyroshnychenko.model.File;
import org.mmyroshnychenko.service.FileService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FileDeleteController extends HttpServlet {
    private final FileService fileService = new FileService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
