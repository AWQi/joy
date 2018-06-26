package com.pojo;

public class Collection {
    private Integer id;

    private Integer dynamicId;

    private Integer userId;

    public Collection(Integer dynamicId, Integer userId) {
		super();
		this.dynamicId = dynamicId;
		this.userId = userId;
	}

	public Collection() {
		super();
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Integer dynamicId) {
        this.dynamicId = dynamicId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}