package net.bitacademy.java41.service;

import java.util.List;

import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

import org.springframework.stereotype.Component;

@Component
public interface ProjectService {
	public List<Project> getProjectList() throws Exception;	
	public List<MemberProject> getMyProjects(String email) throws Exception;
	public Project getProject(int no) throws Exception;
	public void addProject(Project project) throws Exception;	
	public List<MemberProject> listByProjectMember(int no) throws Exception;
	public boolean deleteProject(int no) throws Exception;
	public int updateProject(Project copy) throws Exception;
	public boolean isMyProject(Member member, int no) throws Exception;
	public int getProjectLevel(String email, int no) throws Exception;}













