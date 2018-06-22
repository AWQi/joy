package com.bean;

import java.util.List;

import com.pojo.Comment;

public class DynamicDetails {
    private int id;
    private  String  title ;
    private String imageURL;
    private String videoURL;
    private int praiseNum;
    private int commentsNum;
    private String kind;
    private int authorId;
    private String authorName;
    private String authorHeadUrl;
    private List<Comment> commentList;
    
	public DynamicDetails(int id, String title, String imageURL, String videoURL, int praiseNum, int commentsNum,
			String kind, int authorId, String authorName, String authorHeadUrl) {
		super();
		this.id = id;
		this.title = title;
		this.imageURL = imageURL;
		this.videoURL = videoURL;
		this.praiseNum = praiseNum;
		this.commentsNum = commentsNum;
		this.kind = kind;
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorHeadUrl = authorHeadUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getVideoURL() {
		return videoURL;
	}
	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}
	public int getPraiseNum() {
		return praiseNum;
	}
	public void setPraiseNum(int praiseNum) {
		this.praiseNum = praiseNum;
	}
	public int getCommentsNum() {
		return commentsNum;
	}
	public void setCommentsNum(int commentsNum) {
		this.commentsNum = commentsNum;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorHeadUrl() {
		return authorHeadUrl;
	}
	public void setAuthorHeadUrl(String authorHeadUrl) {
		this.authorHeadUrl = authorHeadUrl;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
    
}
