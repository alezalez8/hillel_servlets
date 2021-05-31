package org.hillel.servlet;

import org.hillel.imageController.UploadImage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ImageServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UploadImage uploadImage = new UploadImage("C:/ua/1.jpg");
        //resp.getOutputStream().write(imageHelper.getImage());
        resp.getOutputStream().flush();
        resp.getOutputStream().close();

    }
}
