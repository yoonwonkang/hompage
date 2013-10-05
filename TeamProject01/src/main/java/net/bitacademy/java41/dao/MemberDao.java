package net.bitacademy.java41.dao;

import java.util.List;
import java.util.Map;

import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Photo;

public interface MemberDao {

	Member getMember(Map<String, String> paramMap) throws Exception;
	void add(Member member) throws Exception;
	List<Member> list() throws Exception;
	Member get(String email) throws Exception;
	int changePassword(	Map<String, String> paramMap) throws Exception;

	void addPhoto(Map<String, String> paramMap) throws Exception;

	void memberRemove(String email) throws Exception;

	int changeMyInfo(Member member) throws Exception;
	/////////////////////////////내가만든 함수//////////////////////
	String emailCheck(String email) throws Exception;
	void memImgRemove(String email) throws Exception;
	void updatePhoto(Map<String, String> paramMap);
	void alterDelete();
	int change(Member member);
	
	public List<Photo> getAllPhoto();
	public Photo getPhoto(String email);
}