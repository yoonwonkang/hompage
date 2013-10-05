package net.bitacademy.java41.service;

import net.bitacademy.java41.vo.Member;

public interface AuthService {

	public Member getUserInfo(String email, String password) throws Exception;
}
