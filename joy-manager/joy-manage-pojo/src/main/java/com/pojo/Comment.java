package com.pojo;

public class Comment {
    private Integer id;

    private Integer userId;

    private Integer synamicId;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSynamicId() {
        return synamicId;
    }

    public void setSynamicId(Integer synamicId) {
        this.synamicId = synamicId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}