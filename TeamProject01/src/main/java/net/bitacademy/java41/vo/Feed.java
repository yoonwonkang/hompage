package net.bitacademy.java41.vo;

import java.io.Serializable;
import java.sql.Date;

public class Feed implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected int feedNo;
	protected int projectNo;
	protected String email;
	protected String content;
	protected Date regDate;
	
	public int getFeedNo() {
		return feedNo;
	}
	public Feed setFeedNo(int feedNo) {
		this.feedNo = feedNo;
		return this;
	}
	public int getProjectNo() {
		return projectNo;
	}
	public Feed setProjectNo(int projectNo) {
		this.projectNo = projectNo;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Feed setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Feed setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getRegDate() {
		return regDate;
	}
	public Feed setRegDate(Date regDate) {
		this.regDate = regDate;
		return this;
	}
	
	public Feed clone(){
		Feed feed = new Feed();
		feed.feedNo = this.feedNo;
		feed.projectNo = this.projectNo;
		feed.email = this.email;
		feed.regDate = this.regDate;
		feed.content = this.content;
		return feed;
	}
	

}
