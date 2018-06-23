package com.test;

public class UserJson  {
	private String password;
	private String name;
    private String tel;
    private String headurl;
    private Integer gender;
    

	public UserJson(String password, String name, String tel, String headurl, Integer gender) {
		super();
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.headurl = headurl;
		this.gender = gender;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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