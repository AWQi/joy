package com.bean;

public class CommentInfo {
	private  int id ;
	private  int dynamicId;
	private  int userId;
	private  String authorImageUrl;
	private  String authorName;
	private  String content;
	private  java.util.Date date;
	
public CommentInfo(int id, int dynamicId, int authorId, String authorImageURL, String authorName, String content,
			java.util.Date date) {
		super();
		this.id = id;
		this.dynamicId = dynamicId;
		this.userId = authorId;
		this.authorImageUrl = authorImageURL;
		this.authorName = authorName;
		this.content = content;
		this.date = date;
}

public int getDynamicId() {
	return dynamicId;
}

public void setDynamicId(int dynamicId) {
	this.dynamicId = dynamicId;
}

public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int authorId) {
		this.userId = authorId;
	}
	public String getAuthorImageUrl() {
		return authorImageUrl;
	}
	public void setAuthorImageUrl(String authorImageURL) {
		this.authorImageUrl = authorImageURL;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}


}
