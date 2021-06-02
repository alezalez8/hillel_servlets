package org.hillel.servlet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;


//@WebServlet("/download/*")
//@RequestMapping("/download/{fileName:.+}")
//public class ImageServlet (@PathVariable(value = "fileName") String fileName ) extends HttpServlet  {

public class ImageServlet extends HttpServlet {

    private String imagePath;

    public void init() throws ServletException {
        this.imagePath = "/ua/journey_service/hillel_servlets/src/main/webapp/img";
    }


    @GetMapping("{name}")
    public String nameJpg(@PathVariable(value = "name") String name) {
        return name;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String requestImage = req.getPathInfo();
        if (requestImage == null) {
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

        if (contentType == null || !contentType.startsWith("img")) {
            // Do your thing if the file appears not being a real image.
            // Throw an exception, or send 404, or show default/warning image, or just ignore it.
            resp.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }
        // если все ОК, то передадим нужный файлик в jsp
        // Init servlet response.
       /* HttpSession session = req.getSession();
        session.setAttribute("nameJpg", "1.jpg");*/
        req.setAttribute("name", "1.jpg");




        // Write image content to response.
       /* Files.copy(image.toPath(), resp.getOutputStream());
        resp.getOutputStream().flush();
        resp.getOutputStream().close();*/



//        req.getRequestDispatcher("/WEB-INF/view/image.jsp").forward(req, resp);
        getServletContext().getRequestDispatcher("/WEB-INF/view/image.jsp").forward(req, resp);

    }
}