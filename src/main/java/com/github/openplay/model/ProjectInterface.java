package com.github.openplay.model;

import java.util.Date;

public interface ProjectInterface {
	
	public int getProjectId();

	public void setProjectId(int projectId);

	public String getName();

	public void setName(String name);

	public int getPoints_Needed();

	public void setPoints_Needed(int points_Needed);

	public int getAcumulated_Points();

	public void setAcumulated_Points (int acumulated_Points);

	public Date getCreation_Date();
	
	public void setCreation_Date(Date creation_Date);
	
	public String getObjective();
	
	public void setObjective(String objective);
	
	public int getUsers_UserId();

	public void setUsers_UserId(int users_UserId);
	
	public int getUsers_Interests_InterestId();

	public void setUsers_Interests_InterestId(int users_Interests_InterestId);
	
	public int getUsers_Roles_RoleId();

	public void setUsers_Roles_RoleId(int users_Roles_RoleId);
	
	public int getProject_States_Project_StateId();

	public void setProject_States_Project_StateId(int project_States_Project_StateId);

}
