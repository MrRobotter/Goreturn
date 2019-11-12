package com.joinyon.houge.bean;

public class MineToolsBean {
    private int imageId;
    private String tool;

    public MineToolsBean(int imageId, String tool) {
        this.imageId = imageId;
        this.tool = tool;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }
}
