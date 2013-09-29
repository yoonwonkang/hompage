package net.bitacademy.java41.dao;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.vo.Task;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskDao {
	@Autowired SqlSessionFactory sqlSessionFactory;

	public TaskDao setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
		return this;
	}

	public List<Task> list(int no) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession(); 
		try{
			return sqlSession.selectList("net.bitacademy.java41.dao.TaskMapper.list", no);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{sqlSession.close();}catch(Exception e){}
		}
		return null;
	}
	
	public Task get(int no) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.selectOne("net.bitacademy.java41.dao.TaskMapper.get", no);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{sqlSession.close();}catch(Exception e){}
		}
		return null;
	}

	public int add(Task task) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			int count = sqlSession.insert("net.bitacademy.java41.dao.TaskMapper.add", task);
			sqlSession.commit();
			return count;
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			try{sqlSession.close();}catch(Exception e){}
		}
		return 0;
	}

	public void update(Task task) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			sqlSession.update("net.bitacademy.java41.dao.TaskMapper.update", task);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			try{sqlSession.close();}catch(Exception e){}
		}
	}
	
	public int remove(int taskNo) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.update("net.bitacademy.java41.dao.TaskMapper.alterDelete");
			int count = sqlSession.delete("net.bitacademy.java41.dao.TaskMapper.remove", taskNo);
			sqlSession.commit();
			return count;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	public int removeProjectTask(int pno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.delete("net.bitacademy.java41.dao.TaskMapper.removeProjectTask", pno);
			sqlSession.commit();
			return count;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
}
