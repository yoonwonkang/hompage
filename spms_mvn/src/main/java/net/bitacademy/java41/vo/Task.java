package net.bitacademy.java41.vo;

import java.sql.Date;

public class Task {
	
	public static final int NON_STARTED_TASK = 0;
	public static final int STARTED_TASK = 1;
	public static final int END_TASK = 2;
	
	private int taskNo;
	private int projectNo;
	private String title;
	private String uiProtoUrl;
	private String content;
	private Date startDate;
	private Date endDate;
	private int status;
	
	public int getTaskNo() {
		return taskNo;
	}
	public Task setTaskNo(int taskNo) {
		this.taskNo = taskNo;
		return this;
	}
	public int getProjectNo() {
		return projectNo;
	}
	public Task setProjectNo(int projectNo) {
		this.projectNo = projectNo;
		return this;
	}
	public String getUiProtoUrl() {
		return uiProtoUrl;
	}
	public Task setUiProtoUrl(String uiProtoUrl) {
		this.uiProtoUrl = uiProtoUrl;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Task setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Task setStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}
	public Date getEndDate() {
		return endDate;
	}
	public Task setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}
	public int getStatus() {
		return status;
	}
	public Task setStatus(int status) {
		this.status = status;
		return this;
	}
	public String getTitle() {
		return title;
		
	}
	public Task setTitle(String title) {
		this.title = title;
		return this;
	}
	public Task clone(){
		Task t = new Task();
		t.taskNo = this.taskNo;
		t.projectNo = this.projectNo;
		t.title = this.title;
		t.uiProtoUrl = this.uiProtoUrl;
		t.content = this.content;
		t.startDate = this.startDate;
		t.endDate = this.endDate;
		t.status = this.status;
		return t;
	}
}
