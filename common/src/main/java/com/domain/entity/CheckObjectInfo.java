package com.domain.entity;

import java.util.Date;

/**
 * 检查材料对象
 */
public class CheckObjectInfo {

    /**
     * 图片信息
     */
    private String img;

    /**
     * 图片标题
     */
    private String imgTitle;

    /**
     * 公司名称
     */
    private String company;

    /**
     * 时间
     */
    private Date time;

    /**
     * 设备名称
     */
    private String device;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgTitle() {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
