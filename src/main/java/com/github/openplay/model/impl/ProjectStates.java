package com.github.openplay.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.github.openplay.model.ProjectStatesInterface;

@Component
@XmlRootElement(name="projectStates")
@Entity
@Table(name="project_states")
public class ProjectStates implements ProjectStatesInterface {
	
	@Id
	@GeneratedValue
	private int project_StateId;
	
	@NotNull
	@Size(min=1, max=60)
	private String status;
	
	public int getProject_StateId() {
		return project_StateId;
	}

	public void setProject_StateId(int project_StateId) {
		this.project_StateId = project_StateId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
