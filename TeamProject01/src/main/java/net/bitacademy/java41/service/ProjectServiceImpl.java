package net.bitacademy.java41.service;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.dao.ProjectMemberDao;
import net.bitacademy.java41.dao.TaskDao;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService {
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
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public void addProject(Project project) throws Exception {
		try{
			projectDao.add(project);
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("email", project.getLeader());
			paramMap.put("projectNo", project.getNo());
			paramMap.put("memberLevel", MemberProject.LVL_LEADER);
			
			System.out.println(project.getLeader());
			projectMemberDao.addProjectMember(paramMap);
		} catch(Exception e){
			throw e;
		} finally {
			
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
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
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public int updateProject(Project copy) throws Exception{
		return projectDao.update(copy);
	}

	public boolean isMyProject(Member member, int no) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("email", member.getEmail());
		paramMap.put("no", no);
		if(projectDao.isMyProject(paramMap) != null){
			return true;
		} else {
			return false;
		}
	}

	public int getProjectLevel(String email, int no) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("email",email);
		paramMap.put("no", no);
		return projectDao.isPL(paramMap).getLevel();
	}

	@Override
	public List<MemberProject> listByProjectMember(int no) throws Exception {
		return projectDao.listByProjectMember(no);
	}
}













