package net.bitacademy.java41.service;

import java.util.List;

import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.dao.ProjectMemberDao;
import net.bitacademy.java41.dao.TaskDao;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectService {
	@Autowired  ProjectDao projectDao;
	@Autowired  ProjectMemberDao projectMemberDao;
	@Autowired  TaskDao taskDao;
	public List<Project> getProjectList() throws Exception {
		return projectDao.list();
	}
	
	public List<MemberProject> getMyProjects(String email) throws Exception {
		return projectDao.listByMember(email);
	}
	public Project getProject(int no) throws Exception {
		return projectDao.get(no);
	}
	
	public void addProject(Project project) throws Exception {
		try{
			projectDao.add(project);
			projectMemberDao.addProjectMember(project.getLeader(), project.getNo(), MemberProject.LVL_LEADER);
		} catch(Exception e){
			throw e;
		} finally {
			
		}
	}
	
	public List<Member> getProjectMember(int no) throws Exception{

		List<Member> memList = null;
		try{
			memList = projectDao.ProjectByMemberList(no);
			return memList;
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			
		}
		return null;
	}
	
	public boolean deleteProject(int no) throws Exception {
		boolean result = false;
		try{
			taskDao.removeProjectTask(no);
			projectMemberDao.deleteProjectMember(no);
			projectDao.delete(no);
			result = true;
			return result;
		}catch(Exception e){
			throw e;
		}finally{
			
		}
	}

	public int updateProject(Project copy) throws Exception{
		return projectDao.update(copy);
	}

	public boolean isMyProject(Member member, int no) throws Exception {
		return projectDao.isMyProject(member.getEmail(), no);
	}

	public int getProjectLevel(String email, int no) throws Exception {
		return projectDao.isPL(email, no);
	}
}













