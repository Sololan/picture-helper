package github.sololan.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GlobalParam {

    // 输出地址
    private String address;

    // 背景图片地址
    private String backgroundPicture;

    // 背景色
    private String backgroundColor;

    // 宽
    private Integer width;

    // 高
    private Integer height;

    // 图片参数列表
    private List<PictureParam> pictureParamList;

    // 图片类型
    private String type;


}
