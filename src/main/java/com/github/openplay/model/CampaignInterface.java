package com.github.openplay.model;

import java.util.Date;

import com.github.openplay.model.impl.CampaignStates;
import com.github.openplay.model.impl.CampaignTypes;
import com.github.openplay.model.impl.Interest;
import com.github.openplay.model.impl.User;

public interface CampaignInterface {

	public Long getId();

	public void setId(Long id);

	public String getName();

	public void setName(String name);

	public Integer getMaxScore();

	public void setMaxScore(Integer maxScore);

	public String getDescription();

	public void setDescription(String description);

	public Date getStartDate();

	public void setStartDate(Date startDate);

	public Date getEndDate();

	public void setEndDate(Date endDate);

	// Fk functions

	public CampaignStates getCampaignState();

	public void setCampaignState(CampaignStates campaignState);

	public CampaignTypes getCampaignType();

	public void setType(CampaignTypes campaignType);

	public Interest getInterest();

	public void setInterest(Interest interest);

	public User getUser();

	public void setUser(User user);

	//public Project getProject();

	//public void setProject(Project project);
	

}