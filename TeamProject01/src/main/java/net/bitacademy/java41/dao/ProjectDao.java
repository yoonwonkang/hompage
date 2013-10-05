package net.bitacademy.java41.dao;

import java.util.List;
import java.util.Map;

import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

public interface ProjectDao {
	public List<Project> list() throws Exception;
	public Project get(int no) throws Exception;
	public List<MemberProject> listByMember(String email) throws Exception;

	public int add(Project project) throws Exception;
	/*바꿔야할 코드*/
	public List<MemberProject> listByProjectMember(int no) throws Exception;
	void alterDelete();
	public void delete(int no) throws Exception;
	public int update(Project project) throws Exception;
	public MemberProject isMyProject(Map<String, Object>paramMap) throws Exception;
	public MemberProject isPL(Map<String, Object>paramMap) throws Exception;
}