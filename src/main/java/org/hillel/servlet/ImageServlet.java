package org.hillel.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/image/*")
public class ImageServlet extends HttpServlet {

    String nameImage = "1.jpg";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();

        req.setAttribute("name", nameImage);

        req.getRequestDispatcher("/WEB-INF/view/image.jsp").forward(req, resp);
    }
}
