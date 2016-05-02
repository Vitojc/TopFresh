package com.youthlin.TopFresh.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by lin on 2016-05-02-002.
 * 上传图片
 */
@Entity
public class ImageUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imgId;
    private String imgTitle;
    private String imgPath;

    public String getImgTitle() {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
