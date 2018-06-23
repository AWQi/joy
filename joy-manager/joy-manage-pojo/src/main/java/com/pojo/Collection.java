package com.pojo;

public class Collection {
    private Integer id;

    private Integer dyid;

    private Integer userid;

    public Collection(Integer dyid, Integer userid) {
		super();
		this.dyid = dyid;
		this.userid = userid;
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

    public Integer getDyid() {
        return dyid;
    }

    public void setDyid(Integer dyid) {
        this.dyid = dyid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}