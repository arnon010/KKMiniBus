package com.app.arnontproject.kkminibus.adapter;

/**
 * Created by arnont on 3/14/18.
 */

public class MiniBus {
    String name;
    String info;
    int imageID;

    public MiniBus(String name, String info, int imageID) {
        this.name = name;
        this.info = info;
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
