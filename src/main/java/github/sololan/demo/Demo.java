package github.sololan.demo;

import github.sololan.EasyPicture;
import github.sololan.bean.PictureParam;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo {
    public static void main(String[] args) throws IOException {

        EasyPicture easyPicture = new EasyPicture();

        PictureParam pictureParam = new PictureParam("C:\\Users\\Sololan\\Desktop\\pic\\water.png",1154,1417,526,524,1139,1311,700,1000,0);
        PictureParam pictureParam2 = new PictureParam("C:\\Users\\Sololan\\Desktop\\pic\\教室7.jpg",1670,1034,526,2000,1500,800,900,1200,0);

        easyPicture.backgroundPicture("C:\\Users\\Sololan\\Desktop\\pic\\template.png").address("C:\\Users\\Sololan\\Desktop\\pic\\end.png")
                .add(pictureParam).add(pictureParam2).build();

    }
}
