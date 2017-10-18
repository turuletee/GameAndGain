package com.github.openplay.model;

import java.util.Date;

public interface CampaignInterface {

	public Long getId();

	public void setId(Long id);

	public String getName();

	public void setName(String name);

	public Int getMaxScore();

	public void setMaxScore(Int maxScore);

	public String getDescription();

	public void setDescription(String description);

	public Date getStartDate();

	public void setStartDate(Date startDate);

	public Date getEndDate();

	public void setEndDate(Date endDate);

	// Fk functions

	public CampaignState getCampaignState();

	public void setCampaignState(CampaignState campaignState);

	public CampaignType getCampaignType();

	public void setType(CampaignType campaignType);

	public Interest getInterest();

	public void setInterest(Interest interest);

	public User getUser();

	public void setUser(User user);

	public Project getProject();

	public void setProject(Project project);
	

}