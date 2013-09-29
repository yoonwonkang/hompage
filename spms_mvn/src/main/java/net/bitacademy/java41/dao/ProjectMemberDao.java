package net.bitacademy.java41.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectMemberDao {
	@Autowired SqlSessionFactory sqlSessionFactory;
	
	public void deleteProjectMember(int no)  {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete(
					"net.bitacademy.java41.dao.ProjectMemberMapper.deleteProjectMember", no);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
			
		}
	}
	
	public void addProjectMember(String email, int no, int memberLevel)  {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("email", email);
			paramMap.put("projectNo", no);
			paramMap.put("memberLevel", memberLevel);
			
			sqlSession.insert(
					"net.bitacademy.java41.dao.ProjectMemberMapper.addProjectMember", 
					paramMap);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
			
		}
	}
}
