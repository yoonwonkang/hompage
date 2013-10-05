package net.bitacademy.java41.service;

import java.util.List;

import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Photo;

public interface MemberService {
	public Member getUserInfo(String email, String password) throws Exception;
	
	public void signUp(Member member) throws Exception;
	
	public List<Member> getMemberList() throws Exception;
	
	public boolean changePassword(
			String email, String oldPassword, String newPassword) throws Exception;
	
	public Member getMember(String email) throws Exception;
	
	public boolean deleteMember(String email) throws Exception;
	
	public String updateMyInfo(Member member, Member origin) throws Exception;
	
	///////////////개인적으로 따로 작성한 메서드///////////////////////////////////////

	public boolean emailDoubleCheck(String email) throws Exception;
	
	public void addPhoto(Member member) throws Exception;
	
	public void update(Member member) throws Exception;
	
	public List<Photo> getAllPhoto() throws Exception;
	public Photo getPhoto(String email) throws Exception;
}

