package ru.aston.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.aston.service.UserService;
import ru.aston.util.JspHelper;

import java.io.IOException;

import static ru.aston.util.UrlPath.ADMIN_PAGE;

@WebServlet(ADMIN_PAGE)
public class AdminPageServlet extends HttpServlet {

    private static final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var users = userService.findAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher(JspHelper.getPath(ADMIN_PAGE))
                .forward(req, resp);
    }

}
