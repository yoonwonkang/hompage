package net.bitacademy.java41.dao;

import java.util.Map;

public interface ProjectMemberDao {
	public void deleteProjectMember(int no);
	public void addProjectMember(Map<String, Object>paramMap);
}
