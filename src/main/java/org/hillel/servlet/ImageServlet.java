package org.hillel.servlet;

import org.hillel.imageController.UploadImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageServlet  extends HttpServlet {
//    private String filename = "1.jpg";
    final private String path = "C:/ua/hillel_servlets/1.jpg";

//    String fullpath = path + File.separator + filename;
    String fullpath = path;


/*

    private String path = "C:/ua/hillel_servlets/1.jpg";
    private BufferedImage img = null;
    private File file = new File(path);


    public BufferedImage getImage() {
        try{
            img = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("File is not present");

        }
        return img;
    }
*/


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* System.out.println("this is jpg");
       // UploadImage uploadImage = new UploadImage("/1.jpg");
        req.setAttribute("image", path);
        req.getAttribute("image");
        //req.setAttribute("image", file.getPath());
//        resp.getOutputStream().write(imageHelper.getImage());
       // resp.getOutputStream().write(img.);
        resp.getOutputStream().flush();
        resp.getOutputStream().close();*/

        req.setAttribute("fullpath", fullpath);
        //System.out.println(img);
        req.getRequestDispatcher("/WEB-INF/view/image.jsp").forward(req, resp);

    }
}
