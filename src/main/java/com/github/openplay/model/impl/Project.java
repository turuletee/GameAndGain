package com.github.openplay.model.impl;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.github.openplay.model.ProjectInterface;

@Component
@XmlRootElement(name="project")
@Entity
@Table(name="projects")
public class Project implements ProjectInterface {
	
	@Id
	@GeneratedValue
	private int projectId;
	
	@NotNull
	@Size(min=1, max=60)
	private String name;
	
	@NotNull
	private int points_Needed;
	
	@NotNull
	private int acumulated_Points;
	
	@NotNull
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date creation_Date;
	
	@NotNull
	@Size(min=1, max=500)
	private String objective;
	
	@NotNull
	private int users_UserId;
	
	@NotNull
	private int users_Interests_InterestId;
	
	@NotNull
	private int users_Roles_RoleId;
	
	@NotNull
	private int project_States_Project_StateId;
	
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints_Needed() {
		return points_Needed;
	}

	public void setPoints_Needed(int points_Needed) {
		this.points_Needed = points_Needed;
	}

	public int getAcumulated_Points() {
		return acumulated_Points;
	}

	public void setAcumulated_Points (int acumulated_Points) {
		this.acumulated_Points = acumulated_Points;
	}

	public Date getCreation_Date() {
		return creation_Date;
	}

	public void setCreation_Date(Date creation_Date) {
		this.creation_Date = creation_Date;
	}
	
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	
	public int getUsers_UserId() {
		return users_UserId;
	}

	public void setUsers_UserId(int users_UserId) {
		this.users_UserId = users_UserId;
	}
	
	public int getUsers_Interests_InterestId() {
		return users_Interests_InterestId;
	}

	public void setUsers_Interests_InterestId(int users_Interests_InterestId) {
		this.users_Interests_InterestId = users_Interests_InterestId;
	}
	
	public int getUsers_Roles_RoleId() {
		return users_Roles_RoleId;
	}

	public void setUsers_Roles_RoleId(int users_Roles_RoleId) {
		this.users_Roles_RoleId = users_Roles_RoleId;
	}
	
	public int getProject_States_Project_StateId() {
		return project_States_Project_StateId;
	}

	public void setProject_States_Project_StateId(int project_States_Project_StateId) {
		this.project_States_Project_StateId = project_States_Project_StateId;
	}
	
}
