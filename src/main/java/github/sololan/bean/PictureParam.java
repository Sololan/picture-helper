package github.sololan.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PictureParam {

    // 图片地址
    private String pictureUrl;

    // 插入位置左上角X坐标
    private Integer areaX;

    // 插入位置左上角Y坐标
    private Integer areaY;

    // 插入宽
    private Integer areaWidth;

    // 插入高
    private Integer areaHeight;

    // 插入图片左上角的X坐标
    private Integer pictureX;

    // 插入图片左上角的Y坐标
    private Integer pictureY;

    // 插入图片的宽
    private Integer pictureWidth;

    // 插入图片的高
    private Integer pictureHeight;

    // 旋转角度
    private Integer angle;

}
