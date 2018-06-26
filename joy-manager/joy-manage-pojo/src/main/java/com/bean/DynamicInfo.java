package com.bean;

import java.util.Date;
import java.util.List;

import com.pojo.Comment;

public class DynamicInfo {
    private int id;
    private String title;
    private String introduction;
    private String imageUrl;
    private String kind;
    private String videoUrl;
    private Integer praisesNum;
    private Integer viewNum;
    private Integer collectNum;
    private Date date;
    
    private int authorId;
    private String authorName;
    private String authorHeadUrl;
    
    
    
	public DynamicInfo(int id, String title, String introduction, String imageUrl, String kind, String videoUrl,
			Integer praisesNum, Integer viewNum, Integer collectNum, Date date, int authorId, String authorName,
			String authorHeadUrl) {
		super();
		this.id = id;
		this.title = title;
		this.introduction = introduction;
		this.imageUrl = imageUrl;
		this.kind = kind;
		this.videoUrl = videoUrl;
		this.praisesNum = praisesNum;
		this.viewNum = viewNum;
		this.collectNum = collectNum;
		this.date = date;
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorHeadUrl = authorHeadUrl;
	}
	public DynamicInfo() {
		super();
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
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public Integer getPraisesNum() {
		return praisesNum;
	}
	public void setPraisesNum(Integer praisesNum) {
		this.praisesNum = praisesNum;
	}
	public Integer getViewNum() {
		return viewNum;
	}
	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}
	public Integer getCollectNum() {
		return collectNum;
	}
	public void setCollectNum(Integer collectNum) {
		this.collectNum = collectNum;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
    
    
    
    

    
}
