package github.sololan.handler;

import github.sololan.bean.GlobalParam;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BuildProcess {
    public static void check(GlobalParam globalParam){
        if(globalParam.getAddress() == null){
            throw new IllegalStateException("请写入输出地址");
        }
    }

    public static void build(GlobalParam globalParam) throws IOException {
        BufferedImage srcImg = ImageIO.read(new File(globalParam.getBackgroundPicture()));
        globalParam.setWidth(srcImg.getWidth());
        globalParam.setHeight(srcImg.getHeight());
    }
}
