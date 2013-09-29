package net.bitacademy.java41.service;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthService {
	@Autowired MemberDao memberDao;
	@Autowired DBConnectionPool dbPool;
		
	public Member getUserInfo(String email, String password) throws Exception{
		return memberDao.getMember(email, password);
	}
}
