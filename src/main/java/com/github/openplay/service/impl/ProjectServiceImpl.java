package com.github.openplay.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.DonationsInterface;
import com.github.openplay.model.UserInterface;
import com.github.openplay.model.impl.Donations;
import com.github.openplay.model.impl.Project;
import com.github.openplay.model.impl.ProjectStates;
import com.github.openplay.model.impl.User;
import com.github.openplay.repository.AdminRepository;
import com.github.openplay.repository.DonationsRepository;
import com.github.openplay.repository.ProjectRepository;
import com.github.openplay.repository.ProjectStatesRepository;
import com.github.openplay.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectStatesRepository projectStatesRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private DonationsRepository donationsRepository;
	
	@Transactional
	public ProjectStates getState(String nameProject) {
		
		Project project = projectRepository.findByName(nameProject);
		int id = project.getProjectId();
		
		ProjectStates states = projectStatesRepository.findById(id);
		return states;
	}
	
	@Transactional
	public Donations updateDonor(String nameProject, String name, Date date) {
		
		Project project = projectRepository.findByName(nameProject);
		int idProject = project.getProjectId();
		
		UserInterface user = adminRepository.findByName(name);
		int idUser = user.getUserId();
		
		DonationsInterface donor = new Donations();
		donor.setProjects_ProjectId(idProject);
		donor.setDate(date);
		donor.setUsers_UserId(idUser);
		
		return donationsRepository.save((Donations)donor);
		
	}

}
