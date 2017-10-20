package com.github.openplay.model;

import java.util.Date;

import com.github.openplay.model.impl.Campaign;
import com.github.openplay.model.impl.Difficulties;

public interface MissionInterface {

	public int getId();

	public void setId(int missionId);

	public String getName();

	public void setName(String name);

	public Integer getScore();

	public void setScore(Integer score);

	public String getDescription();

	public void setDescription(String description);


	// Fk functions

	public Campaign getCampaign();

	public void setCampaign(Campaign campaign);

	public Difficulties getDifficulty();

	public void setDifficulty(Difficulties difficulty);

}