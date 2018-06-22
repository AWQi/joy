package com.bean;
import com.pojo.UserKey;

public class UserInfo  {
	private int id;
	private String name;
    private String tel;
    private String headurl;
    private Integer gender;
    
	public UserInfo(int id, String name, String tel, String headurl, Integer gender) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.headurl = headurl;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHeadurl() {
		return headurl;
	}
	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}


}