package org.hillel.servlet;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

//@WebServlet("/download/{name_image:.+}")
@WebServlet("/download/*")
public class ImageServletNew extends HttpServlet {


    String imagePath;

    // set path to target folder with pictures
    public void init() throws ServletException {
        imagePath = "/ua/journey_service/hillel_servlets/src/main/webapp/WEB-INF/images";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String filename = URLDecoder.decode(req.getPathInfo().substring(1), "UTF-8");
        File file = new File(imagePath, filename);
        if (!file.exists()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        resp.setHeader("Content-Type", getServletContext().getMimeType(filename));
        resp.setHeader("Content-Length", String.valueOf(file.length()));
        resp.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
        try {
            Files.copy(file.toPath(), resp.getOutputStream());
            resp.getOutputStream().flush();
        } catch (IOException e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

        // ======================= output file .jpg with image.jsp
        // String nameImage = "1.jpg";
        // final HttpSession session = req.getSession();
        //  req.setAttribute("name", nameImage);
        req.getRequestDispatcher("/WEB-INF/view/image.jsp").forward(req, resp);
    }
}
