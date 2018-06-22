package com.pojo;

import java.util.Date;

public class Dynamic {
    private Integer id;

    private String title;

    private String imageurl;

    private String introduction;

    private String videourl;

    private Integer praisesnum;

    private String kind;

    private Date date;

    private Integer viewnum;

    private Integer collnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl == null ? null : videourl.trim();
    }

    public Integer getPraisesnum() {
        return praisesnum;
    }

    public void setPraisesnum(Integer praisesnum) {
        this.praisesnum = praisesnum;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind == null ? null : kind.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getViewnum() {
        return viewnum;
    }

    public void setViewnum(Integer viewnum) {
        this.viewnum = viewnum;
    }

    public Integer getCollnum() {
        return collnum;
    }

    public void setCollnum(Integer collnum) {
        this.collnum = collnum;
    }
}