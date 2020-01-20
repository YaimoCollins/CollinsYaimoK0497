package com.example.collinsyaimok0497;

public class PretPark {
    private String title;
    private String id;

    public PretPark(String title, String desc, String image, String id) {
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.id = id;
    }

    private String desc;
    private String image;

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public PretPark(){

    }
}
