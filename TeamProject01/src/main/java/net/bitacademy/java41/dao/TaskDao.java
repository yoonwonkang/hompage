package net.bitacademy.java41.dao;

import java.util.List;

import net.bitacademy.java41.vo.Task;

public interface TaskDao {

	public List<Task> list(int no) throws Exception;
	public List<Task> listAll() throws Exception;	
	public Task get(int no) throws Exception;
	public int add(Task task) throws Exception;
	public void update(Task task) throws Exception ;	
	public int remove(int taskNo) throws Exception ;
	public int removeProjectTask(int pno) throws Exception;
	void alterDelete();
}
