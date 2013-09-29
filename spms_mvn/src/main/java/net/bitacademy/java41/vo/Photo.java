package net.bitacademy.java41.vo;

public class Photo {
	protected String email;
	protected String fileName;
	protected int imageNo;
	
	public String getEmail() {
		return email;
	}
	public Photo setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getFileName() {
		return fileName;
	}
	public Photo setFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}
	public int getImageNo() {
		return imageNo;
	}
	public Photo setImageNo(int imageNo) {
		this.imageNo = imageNo;
		return this;
	}
	
	
}
