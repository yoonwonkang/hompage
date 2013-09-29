package net.bitacademy.java41.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberService {
	@Autowired MemberDao memberDao;

	public Member getUserInfo(String email, String password) throws Exception{
		return memberDao.getMember(email, password);
	}

	public void signUp(Member member) throws Exception {
		try{
			memberDao.add(member);
			String[] photos = member.getPhotos();
			if(photos != null){
				for(String path : photos){
					memberDao.addPhoto(member.getEmail(), path);
				}
			}
		}catch(Exception e){
			throw e;
		}finally{

		}
	}

	public List<Member> getMemberList() throws Exception {
		return memberDao.list();
	}

	public boolean changePassword(
			String email, String oldPassword, String newPassword) throws Exception {
		if (memberDao.changePassword(email, oldPassword, newPassword) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public Member getMember(String email) throws Exception {
		return memberDao.get(email);
	}

	public boolean deleteMember(String email) throws Exception{
		boolean result = false;
		try{
			memberDao.memImgRemove(email);
			memberDao.memberRemove(email);
			result = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{

		}
		return result;
	}

	public String updateMyInfo(Member member, HttpSession session) throws Exception{
		if(memberDao.changeMyInfo(member) > 0){
			String[] photos = member.getPhotos();
			Member origin = (Member)session.getAttribute("member");
			if(photos != null){
				for(String path : photos){
					if(origin.getPhotos() != null){
						memberDao.updatePhoto(member.getEmail(), path);
					} else {
						memberDao.addPhoto(member.getEmail(), path);
					}
				}
			}
			return "SUCCESS";
		} else {			
			return "FAIL";
		}
	}
	///////////////개인적으로 따로 작성한 메서드///////////////////////////////////////

	public boolean emailDoubleCheck(String email) throws Exception {
		if(memberDao.emailCheck(email)){
			return true;
		} 
		return false;
	}

	public void addPhoto(Member member) throws Exception{
		String[] photos = member.getPhotos();
		if(photos != null){
			for(String path : photos){
				memberDao.updatePhoto(member.getEmail(), path);
			}
		}
	}

	public void update(Member member) throws Exception {
		if(memberDao.change(member) > 0){

			Member origin = memberDao.getMember(member.getEmail(), member.getPassword());
			String[] photos = member.getPhotos();
			if(photos != null){
				for(String path : photos){
					if(origin.getPhotos() != null){
						memberDao.updatePhoto(member.getEmail(), path);
					} else {
						memberDao.addPhoto(member.getEmail(), path);
					}
				}
			}
		}
	}
}

