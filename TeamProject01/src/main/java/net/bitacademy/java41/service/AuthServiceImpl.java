package net.bitacademy.java41.service;

import java.util.HashMap;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired MemberDao memberDao;

	public Member getUserInfo(String email, String password) throws Exception{
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("email", email);
		paramMap.put("password", password);
		////////////수정/////////////
		Member member = memberDao.getMember(paramMap);
		if(member != null){
			String [] photos = new String[1];
			if(memberDao.getPhoto(email) != null){
				photos[0] = memberDao.getPhoto(email).getFileName();
				member.setPhotos(photos);
			}
		}

		return member;
	}
}
