package net.bitacademy.java41.service;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao memberDao;

	public Member getUserInfo(String email, String password) throws Exception {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("email", email);
		paramMap.put("password", password);
		Member member = memberDao.getMember(paramMap);
		String[] photos = new String[1];
		if (memberDao.getPhoto(email) != null) {
			photos[0] = memberDao.getPhoto(email).getFileName();
			member.setPhotos(photos);
		}

		return member;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public void signUp(Member member) throws Exception {
		try {
			HashMap<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("email", member.getEmail());
			memberDao.add(member);
			String[] photos = member.getPhotos();
			if (photos != null) {
				for (String path : photos) {
					paramMap.put("path", path);
					memberDao.addPhoto(paramMap);
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {

		}
	}

	public List<Member> getMemberList() throws Exception {
		return memberDao.list();
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public boolean changePassword(String email, String oldPassword,
			String newPassword) throws Exception {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("newPassword", newPassword);
		paramMap.put("oldPassword", oldPassword);
		paramMap.put("email", email);
		if (memberDao.changePassword(paramMap) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public Member getMember(String email) throws Exception {
		Member member = memberDao.get(email);
		String[] photos = new String[1];
		if (memberDao.getPhoto(email) != null) {
			photos[0] = memberDao.getPhoto(email).getFileName();
			member.setPhotos(photos);
		}

		return member;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public boolean deleteMember(String email) throws Exception {
		boolean result = false;
		try {
			memberDao.alterDelete();
			memberDao.memImgRemove(email);
			memberDao.memberRemove(email);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public String updateMyInfo(Member member, Member origin) throws Exception {
		if (memberDao.changeMyInfo(member) > 0) {

			String[] photos = member.getPhotos();
			if (photos != null) {
				HashMap<String, String> paramMap = new HashMap<String, String>();
				paramMap.put("email", origin.getEmail());
				for (String path : photos) {
					paramMap.put("path", path);
					if (origin.getPhotos() != null) {
						memberDao.memImgRemove(origin.getEmail());
					}
					memberDao.addPhoto(paramMap);
				}
			} else {
				memberDao.memImgRemove(member.getEmail());
			}
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	// /////////////개인적으로 따로 작성한 메서드///////////////////////////////////////

	public boolean emailDoubleCheck(String email) throws Exception {
		if (memberDao.emailCheck(email) != null) {
			return true;
		}
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public void addPhoto(Member member) throws Exception {
		String[] photos = member.getPhotos();
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("email", member.getEmail());

		if (photos != null) {
			for (String path : photos) {
				paramMap.put("path", path);
				memberDao.updatePhoto(paramMap);
			}
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public void update(Member member) throws Exception {
		if (memberDao.change(member) > 0) {
			HashMap<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("email", member.getEmail());
			paramMap.put("password", member.getPassword());

			Member origin = memberDao.get(member.getEmail());
			String[] photos = member.getPhotos();
			if (photos != null) {
				for (String path : photos) {
					if (origin.getPhotos() != null) {
						paramMap.put("path", path);
						if (origin.getPhotos() != null) {
							memberDao.memImgRemove(origin.getEmail());
						}
						memberDao.addPhoto(paramMap);
					}
				}
			} else {
				memberDao.memImgRemove(member.getEmail());
			}
		}
	}

	@Override
	public List<Photo> getAllPhoto() {
		return memberDao.getAllPhoto();
	}

	@Override
	public Photo getPhoto(String email) throws Exception {
		return memberDao.getPhoto(email);
	}
}
