package net.bitacademy.java41.dao;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Photo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	@Autowired SqlSessionFactory sqlSessionFactory;

	public MemberDao setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
		return this;
	}

	public Member getMember(String email, String password) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("email", email);
			paramMap.put("password", password);
			Member member = sqlSession.selectOne(
					"net.bitacademy.java41.dao.MemberMapper.getMember",
					paramMap);

			String[] photos = null;
			List<Photo> list = this.listPhoto(email);
			if(list.size()>0){
				photos = new String[list.size()];
				int index = 0;
				for(Photo photo : list){
					photos[index++] = photo.getFileName();
				}
			}
			if(member != null){//로그인이 실패했을경우 member가 널이므로
				return member.setPhotos(photos);
			} else {
				return member;//널일경우에 setPhoto를 부른다면 error발생 그래서 if문 처리
			}
		}catch(Exception e){
			throw e;
		}finally{
			try{sqlSession.close();}catch(Exception e){}
		}
	}

	private List<Photo> listPhoto(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.selectList("net.bitacademy.java41.dao.MemberMapper.listPhoto",email);
		}catch(Exception e){
			throw e;
		}finally{
			try{sqlSession.close();} catch (Exception e){}
		}
	}

	public void add(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			sqlSession.insert("net.bitacademy.java41.dao.MemberMapper.add", member);
			sqlSession.commit();
			return;
		}catch(Exception e){
			sqlSession.rollback();
			throw e;
		} finally{
			try{sqlSession.close();}catch(Exception e){}
		}
	}

	public List<Member> list() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList("net.bitacademy.java41.dao.MemberMapper.list");
		} catch (Exception e) {
			throw e;
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public Member get(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne("net.bitacademy.java41.dao.MemberMapper.get", email);
		} catch (Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public int changePassword(
			String email, String oldPassword, String newPassword) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("newPassword", newPassword);
			params.put("oldPassword", oldPassword);
			params.put("email", email);
			int count = sqlSession.update("net.bitacademy.java41.dao.MemberMapper.changePassword",params);
			sqlSession.commit();
			return count;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}

	public void addPhoto(String email, String path) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("email", email);
			params.put("path", path);
			sqlSession.insert("net.bitacademy.java41.dao.MemberMapper.addPhoto", params);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw e;
		}finally{
			try{sqlSession.close();}catch(Exception e){}
		}
	}

	public void memberRemove(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			sqlSession.update("net.bitacademy.java41.dao.MemberMapper.alterDelete");
			sqlSession.delete("net.bitacademy.java41.dao.MemberMapper.memberRemove", email);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			try {sqlSession.close();} catch(Exception e){}
		}
	}

	public int changeMyInfo(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.update("net.bitacademy.java41.dao.MemberMapper.changeMyInfo", member);
			sqlSession.commit();
			return count;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;

		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	/////////////////////////////내가만든 함수//////////////////////
	public boolean emailCheck(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			String check = sqlSession.selectOne("net.bitacademy.java41.dao.MemberMapper.emailCheck", email);
			if(check != null){
				return true;
			} else {
				return false;
			}
		}catch(Exception e){
			throw e;
		} finally{
			try{sqlSession.close();}catch(Exception e){}
		}
	}

	public void memImgRemove(String email) throws Exception {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		try{
			sqlSession.delete("net.bitacademy.java41.dao.MemberMapper.memImgRemove", email);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw e;
		}finally{
			try{sqlSession.close();}catch(Exception e){}
		}
	}

	public void updatePhoto(String email, String path) {
		SqlSession sqlSession =sqlSessionFactory.openSession();
		try{
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("email",email);
			paramMap.put("path", path);
			int count = sqlSession.update("net.bitacademy.java41.dao.MemberMapper.updateImg", paramMap);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw e;
		}finally{
			try{sqlSession.close();}catch(Exception e){}
		}
	}

	public int change(Member member) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.update("net.bitacademy.java41.dao.MemberMapper.change", member);
			sqlSession.commit();
			return count;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;

		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
}

/*
 * 
			stmt = con.prepareStatement("insert into SPMS_MEMBS("
					+ "EMAIL,MNAME,PWD,TEL,BLOG,REG_DATE,UPDATE_DATE,ANO,DET_ADDR,TAG,LEVEL)"
					+ " values(?,?,?,?,?,now(),now(),?,?,?,?)");


 */
