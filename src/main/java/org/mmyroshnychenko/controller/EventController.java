package org.mmyroshnychenko.controller;

import org.mmyroshnychenko.model.Event;
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

public class EventController extends HttpServlet {
    private EventService eventService = new EventService();
    private UserService userService = new UserService();
    private FileService fileService = new FileService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = null;
        Long fileId = null;
        String strUserId = request.getParameter("userId");
        String strFileId = request.getParameter("fileId");
        if (strUserId != null) {
            userId = Long.valueOf(strUserId);
        }
        if (strFileId != null) {
            fileId = Long.valueOf(strFileId);
        }
        if (userId == null && fileId == null) {
            request.getRequestDispatcher("view/eventIncorrectRequest.jsp").forward(request, response);
            return;
        }
        User user = null;
        if (userId != null) {
            user = userService.getById(userId);
            if (user == null) {
                request.getRequestDispatcher("view/userNotFound.jsp").forward(request, response);
                return;
            }
        }
        File file = null;
        if (fileId != null) {
            file = fileService.getById(fileId);
            if (file == null) {
                request.getRequestDispatcher("view/fileNotFound.jsp").forward(request, response);
                return;
            }
        }
        List<Event> events = eventService.getByUserAndFile(user, file);
        request.setAttribute("eventsList", events);
        request.getRequestDispatcher("view/eventsList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
