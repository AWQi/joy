package com.bean;

import java.util.List;

import com.pojo.Comment;

public class DynamicDetails {
    private int id;
    private int authorId;
    private String authorName;
    private String authorHeadUrl;
    private List<Comment> commentList;
    private List<String> commentAuthorHeadList;
    private List<Integer> commentAuthorIdList;
    
    
	public DynamicDetails(int id, int authorId, String authorName, String authorHeadUrl, List<Comment> commentList,
			List<String> commentAuthorHeadList, List<Integer> commentAuthorIdList) {
		super();
		this.id = id;
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorHeadUrl = authorHeadUrl;
		this.commentList = commentList;
		this.commentAuthorHeadList = commentAuthorHeadList;
		this.commentAuthorIdList = commentAuthorIdList;
	}
	public List<String> getCommentAuthorHeadList() {
		return commentAuthorHeadList;
	}
	public void setCommentAuthorHeadList(List<String> commentAuthorHead) {
		this.commentAuthorHeadList = commentAuthorHead;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<Integer> getCommentAuthorIdList() {
		return commentAuthorIdList;
	}
	public void setCommentAuthorIdList(List<Integer> commentAuthorIdList) {
		this.commentAuthorIdList = commentAuthorIdList;
	}
    
}
