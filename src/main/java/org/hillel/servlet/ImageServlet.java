package org.hillel.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;


//@WebServlet("/download/*")
public class ImageServlet extends HttpServlet {

     private String imagePath; //= "C:\\ua\\journey_service\\hillel_servlets\\src\\main\\webapp\\img\\1.jpg";

public void init() throws ServletException {
    this.imagePath = "/ua/journey_service/hillel_servlets/src/main/webapp/img";
}


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String requestImage = req.getPathInfo();
    if(requestImage == null){
        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        return;
    }

        File image = new File(imagePath, URLDecoder.decode(requestImage, "UTF-8"));
        if (!image.exists()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String contentType = getServletContext().getMimeType(image.getName());

        // Check if file is actually an image (avoid download of other files by hackers!).
        // For all content types, see: http://www.w3schools.com/media/media_mimeref.asp
        if (contentType == null || !contentType.startsWith("img")) {
            // Do your thing if the file appears not being a real image.
            // Throw an exception, or send 404, or show default/warning image, or just ignore it.
            resp.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }

        // Init servlet response.
        resp.reset();
        resp.setContentType(contentType);
        resp.setHeader("Content-Length", String.valueOf(image.length()));

        // Write image content to response.
        Files.copy(image.toPath(), resp.getOutputStream());

        req.getRequestDispatcher("/WEB-INF/view/image.jsp").forward(req, resp);

    }
}
