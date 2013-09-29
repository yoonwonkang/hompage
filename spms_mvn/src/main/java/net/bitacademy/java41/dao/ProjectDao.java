package net.bitacademy.java41.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectDao {
	@Autowired SqlSessionFactory sqlSessionFactory;
	
	public ProjectDao setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
		return this;
	}

	public List<Project> list() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList("net.bitacademy.java41.dao.ProjectMapper.list");
		} catch (Exception e) {
			throw e;
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public Project get(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne("net.bitacademy.java41.dao.ProjectMapper.get",no);
		} catch (Exception e) {
			throw e;	
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	public List<MemberProject> listByMember(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList(
					"net.bitacademy.java41.dao.ProjectMapper.listByMember",
					email);
		} catch (Exception e) {
			throw e;
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public int add(Project project) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.insert(
				"net.bitacademy.java41.dao.ProjectMapper.add", project);
			sqlSession.commit();
			return project.getNo();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}

	public ArrayList<Member> ProjectByMemberList(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Member member = null;
		ArrayList<Member> memberlist = new ArrayList<Member>();
		try {
			List<MemberProject> projectMemberList = sqlSession.selectList("net.bitacademy.java41.dao.ProjectMapper.getProjectMember", no);
			String email = null;
			for(MemberProject mp : projectMemberList) {
				mp.setNo(no);
				
				email = mp.getEmail();

				member = sqlSession.selectOne("net.bitacademy.java41.dao.MemberMapper.get", email);
				if(member != null){
					member
					.setMemLevel(mp.getLevel());
					memberlist.add(member);
				}
			}
			return memberlist;
		} catch (Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}

	}


	public void delete(int no) throws Exception  {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete(
					"net.bitacademy.java41.dao.ProjectMapper.delete", no);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public int update(Project project) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.update(
				"net.bitacademy.java41.dao.ProjectMapper.update", project);
			sqlSession.commit();
			return count;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
		
	}
	

	public boolean isMyProject(String email, int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("email", email);
		paramMap.put("no", no);
		try{
			MemberProject mp = sqlSession.selectOne("net.bitacademy.java41.dao.ProjectMapper.isMyProject", paramMap);
			if(mp != null){
				return true; 
			} else {
				return false;
			}			
		}catch(Exception e){
			throw e;
		}finally{
			try{sqlSession.close();}catch(Exception e){}
		}
	}

	public int isPL(String email, int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("email", email);
		paramMap.put("no", no);
		try{
			MemberProject mp =  sqlSession.selectOne("net.bitacademy.java41.dao.ProjectMapper.isPL", paramMap);
			if(mp.getLevel() == 0){
				return MemberProject.LVL_LEADER;
			} else {
				return MemberProject.LVL_GENERAL;
			}
		}catch(Exception e){
			throw e;
		}finally{
			try{sqlSession.close();}catch(Exception e){}
		}
	}
}