package github.sololan;

import github.sololan.bean.GlobalParam;
import github.sololan.bean.PictureParam;
import github.sololan.handler.BuildProcess;
import github.sololan.handler.PictureHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EasyPicture {

    private GlobalParam globalParam = new GlobalParam();

    public EasyPicture address(String address) {
        globalParam.setAddress(address);
        return this;
    }

    public EasyPicture backgroundPicture(String backgroundPicture) {
        globalParam.setBackgroundPicture(backgroundPicture);
        return this;
    }

    public EasyPicture backgroundColor(String backgroundColor) {
        globalParam.setBackgroundColor(backgroundColor);
        return this;
    }

    public EasyPicture type(String type) {
        globalParam.setType(type);
        return this;
    }

    public EasyPicture add(PictureParam pictureParam) {
        if(globalParam.getPictureParamList() == null) globalParam.setPictureParamList(new ArrayList<PictureParam>());
        globalParam.getPictureParamList().add(pictureParam);
        return this;
    }

    public EasyPicture add(List<PictureParam> list) {
        if(globalParam.getPictureParamList() == null) globalParam.setPictureParamList(new ArrayList<PictureParam>());
        for (PictureParam pictureParam :
                list) {
            globalParam.getPictureParamList().add(pictureParam);
        }
        return this;
    }

    public EasyPicture build() throws IOException {

        BuildProcess.check(this.globalParam);

        BuildProcess.build(this.globalParam);

        PictureHandler.rectHander(this.globalParam);

        return this;
    }

}
