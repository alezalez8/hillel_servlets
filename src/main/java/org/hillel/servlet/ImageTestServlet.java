package org.hillel.servlet;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/download/*")
public class ImageTestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String exten = req.getParameter("exten");
        try {
            writer.println("<h2>Id:" + exten + "</h2>");
        } finally {
            writer.close();
        }
        PrintWriter writer1 = resp.getWriter();
        BufferedImage bufferedImage = ImageIO.read(new File("C:/jpg/1.jpg"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", baos);
        baos.flush();
        byte[] imageByteArray = baos.toByteArray();
        baos.close();
        writer1.print(Arrays.toString(imageByteArray));
        // super.doGet(req, resp);
    }
}
