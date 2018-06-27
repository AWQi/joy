package com.bean;


public class UserInfo  {
	private int id;
	private String name;
    private String tel;
    private String headUrl;
    private Integer gender;
    private Integer myAttentNum;
    private Integer myFanNum;
    private Integer myDynamicNum;
    public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	public UserInfo(int id, String name, String tel, String headurl, Integer gender) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.headUrl = headurl;
		this.gender = gender;
	}
	
	
	public UserInfo(int id, String name, String tel, String headUrl, Integer gender, Integer myAttentNum,
			Integer myFanNum, Integer myDynamicNum) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.headUrl = headUrl;
		this.gender = gender;
		this.myAttentNum = myAttentNum;
		this.myFanNum = myFanNum;
		this.myDynamicNum = myDynamicNum;
	}
	public int getId() {
		return id;
	}
	
	public Integer getMyAttentNum() {
		return myAttentNum;
	}
	public void setMyAttentNum(Integer myAttentNum) {
		this.myAttentNum = myAttentNum;
	}
	public Integer getMyFanNum() {
		return myFanNum;
	}
	public void setMyFanNum(Integer myFanNum) {
		this.myFanNum = myFanNum;
	}
	public Integer getMyDynamicNum() {
		return myDynamicNum;
	}
	public void setMyDynamicNum(Integer myDynamicNum) {
		this.myDynamicNum = myDynamicNum;
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
		return headUrl;
	}
	public void setHeadurl(String headurl) {
		this.headUrl = headurl;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}


}