package com.pojo;

public class Studio {
    private Integer id;

    private String imageurl;

    private String title;

    private Integer premiere;

    private String studiourl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getPremiere() {
        return premiere;
    }

    public void setPremiere(Integer premiere) {
        this.premiere = premiere;
    }

    public String getStudiourl() {
        return studiourl;
    }

    public void setStudiourl(String studiourl) {
        this.studiourl = studiourl == null ? null : studiourl.trim();
    }
}