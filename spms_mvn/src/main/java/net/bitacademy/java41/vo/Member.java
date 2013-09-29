package net.bitacademy.java41.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {

	private static final int GENERAL = 0;
	private static final int PROJECT_MANAGER = 1;
	private static final int GUEST = 9;
	
	private static final long serialVersionUID = 1L;

	protected String email;
	protected String name;
	protected String password;
	protected String tel;
	protected String blog;
	protected Date regDate;
	protected Date updateDate;
	protected int addrNo;
	protected String detailAddr;
	protected String tag;
	protected int memLevel;
	protected String[] photos;
	
	public String[] getPhotos() {
		return photos;
	}
	public Member setPhotos(String[] photos) {
		this.photos = photos;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Member setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getName() {
		return name;
	}
	public Member setName(String name) {
		this.name = name;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public Member setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getTel() {
		return tel;
	}
	public Member setTel(String tel) {
		this.tel = tel;
		return this;
	}
	public String getBlog() {
		return blog;
	}
	public Member setBlog(String blog) {
		this.blog = blog;
		return this;
	}
	public Date getRegDate() {
		return regDate;
	}
	public Member setRegDate(Date regDate) {
		this.regDate = regDate;
		return this;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public Member setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
	public int getAddrNo() {
		return addrNo;
	}
	public Member setAddrNo(int addrNo) {
		this.addrNo = addrNo;
		return this;
	}
	public String getDetailAddr() {
		return detailAddr;
	}
	public Member setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
		return this;
	}
	public String getTag() {
		return tag;
	}
	public Member setTag(String tag) {
		this.tag = tag;
		return this;
	}
	public int getMemLevel() {
		return memLevel;
	}
	public Member setMemLevel(int memLevel) {
		this.memLevel = memLevel;
		return this;
	}
	
	
	public Member clone(){
		Member m = new Member();
		m.email = this.email;
		m.name = this.name;
		m.password = this.password;
		m.tel = this.tel;
		m.blog = this.blog;
		m.detailAddr = this.detailAddr;
		m.addrNo = this.addrNo;
		m.photos = this.photos;
		m.regDate = this.regDate;
		m.updateDate = this.updateDate;
		m.memLevel = this.memLevel;
		m.tag = this.tag;
		return m;
	}
}
