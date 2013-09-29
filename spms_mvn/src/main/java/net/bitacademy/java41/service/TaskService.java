package net.bitacademy.java41.service;

import java.util.List;

import net.bitacademy.java41.dao.TaskDao;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskService {
	@Autowired	TaskDao taskDao;
	@Autowired	DBConnectionPool dbPool;

	public List<Task> getTaskList(int no) throws Exception {
		return taskDao.list(no);
	}

	public Task getTask(int no) throws Exception {
		return taskDao.get(no);
	}

	public int addTask(Task t) throws Exception {
		return taskDao.add(t);
	}

	public void updateTask(Task t) throws Exception {
		taskDao.update(t);
	}

	public void removeTask(int taskNo) throws Exception {
		taskDao.remove(taskNo);
	}
}
