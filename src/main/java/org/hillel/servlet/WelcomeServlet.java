package org.hillel.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
//@WebServlet(urlPatterns = "/welcome", name = "welcomeServlet", loadOnStartup = 1)

public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // resp.getWriter().println("<html><body><h1>Welcome message Привет-привет</h1></body></html>");


        final HttpSession session = req.getSession(); // проверка, есть ли открытая сессия, и если нет, то открывает ее
        final String token = (String) session.getAttribute("token");
        if (token == null) {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);

        } else {
            resp.getWriter().println("<html><body><h1>Привет: " + token + "</h1></body></html>");
        }
    }
}
