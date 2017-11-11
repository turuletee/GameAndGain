package com.github.openplay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.impl.Project;
import com.github.openplay.model.impl.ProjectStates;
import com.github.openplay.repository.ProjectRepository;
import com.github.openplay.repository.ProjectStatesRepository;
import com.github.openplay.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectStatesRepository projectStatesRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Transactional
	public ProjectStates getState(String nameProject) {
		
		Project project = projectRepository.findByName(nameProject);
		int id = project.getProjectId();
		
		ProjectStates states = projectStatesRepository.findById(id);
		return states;
	}

}
