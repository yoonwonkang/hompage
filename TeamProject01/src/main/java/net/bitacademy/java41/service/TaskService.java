package net.bitacademy.java41.service;

import java.util.List;

import net.bitacademy.java41.vo.Task;

public interface TaskService {
	public List<Task> getTaskList(int no) throws Exception;
	public List<Task> taskAllList() throws Exception;
	public Task getTask(int no) throws Exception;
	public int addTask(Task t) throws Exception;
	public void updateTask(Task t) throws Exception;
	public void removeTask(int taskNo) throws Exception;
}
