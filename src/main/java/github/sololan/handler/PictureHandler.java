package github.sololan.handler;

import github.sololan.bean.GlobalParam;
import github.sololan.bean.PictureParam;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PictureHandler {

    public static BufferedImage finalBuffer;

    public static void rectHander(GlobalParam globalParam) throws IOException {
        finalBuffer = new BufferedImage(globalParam.getWidth(),globalParam.getHeight()
                , BufferedImage.TYPE_INT_ARGB);

        Graphics finalG = finalBuffer.getGraphics();

        for (PictureParam pic:
             globalParam.getPictureParamList()) {
            BufferedImage srcImg = ImageIO.read(new File(pic.getPictureUrl()));
            // 创建一个和底图一样的画布
            BufferedImage buffImg = new BufferedImage(globalParam.getWidth(),globalParam.getHeight()
                    , BufferedImage.TYPE_INT_ARGB);

            Graphics2D g = buffImg.createGraphics();

            // 旋转
            g.rotate(Math.toRadians(pic.getAngle()), pic.getPictureX() + pic.getPictureWidth()/2, pic.getPictureY() + pic.getPictureHeight()/2);

            // 加图
            g.drawImage(srcImg, pic.getPictureX(), pic.getPictureY(),pic.getPictureWidth(),pic.getPictureHeight(), null);

            // 放下画笔
            g.dispose();

            // 截取指定大小的图片
            buffImg = buffImg.getSubimage(pic.getAreaX(),pic.getAreaY(),pic.getAreaWidth(),pic.getAreaHeight());

            // 获取小框大小的画布
            BufferedImage temBuf = new BufferedImage(pic.getAreaWidth(),pic.getAreaHeight(), BufferedImage.TYPE_INT_ARGB);

            // 把图片放入小框，以完成去除多余部分的功能
            temBuf.getGraphics().drawImage(buffImg.getScaledInstance(pic.getAreaWidth(),pic.getAreaHeight(), java.awt.Image.SCALE_SMOOTH), 0, 0, null);

            // 用画笔把合成后的图片画在指定位置
            finalG.drawImage(temBuf,pic.getAreaX(),pic.getAreaY(),pic.getAreaWidth(),pic.getAreaHeight(),null);

        }

        // 读取背景图
        BufferedImage backImg = ImageIO.read(new File(globalParam.getBackgroundPicture()));

        // 写入背景图
        finalG.drawImage(backImg,0,0,globalParam.getWidth(),globalParam.getHeight(),null);

        // 封笔
        finalG.dispose();

        // 输出到指定位置
        OutputStream os = new FileOutputStream(globalParam.getAddress());

        // 生成图片
        String formatName;
        formatName = globalParam.getType() == null ? "png" : globalParam.getType();
        ImageIO.write(finalBuffer, formatName, os);

        System.out.println("图片合成");

        os.close();

    }
}
