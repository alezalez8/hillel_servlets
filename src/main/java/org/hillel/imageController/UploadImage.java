package org.hillel.imageController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UploadImage {
    private String path;
    private BufferedImage img = null;
    private File file = null;

    public UploadImage(String path) {
        this.path = path;
        file = new File(path);
    }

    public BufferedImage getImage() {
        try{
            img = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("File is not present");

        }
        return img;
    }

}
