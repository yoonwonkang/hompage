package net.bitacademy.java41.vo;

import java.io.Serializable;

public class MemberProject implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final int LVL_LEADER = 0;
	public static final int LVL_GENERAL = 1;
	public static final int LVL_GUEST = 9;
	
	protected int no; 
	protected String email;
	protected int level;
	protected String name;
	protected String title;
	
	
	
	public String getName() {
		return name;
	}
	public MemberProject setName(String name) {
		this.name = name;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public MemberProject setTitle(String title) {
		this.title = title;
		return this;
	}
	public int getNo() {
		return no;
	}
	public MemberProject setNo(int no) {
		this.no = no;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public MemberProject setEmail(String email) {
		this.email = email;
		return this;
	}
	public int getLevel() {
		return level;
	}
	public MemberProject setLevel(int level) {
		this.level = level;
		return this;
	}
}
