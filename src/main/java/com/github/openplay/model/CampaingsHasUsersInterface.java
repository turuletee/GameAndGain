package com.github.openplay.model;

import com.github.openplay.model.impl.Campaign;
import com.github.openplay.model.impl.User;

public interface CampaingsHasUsersInterface {
	
	public Integer getIdCampaigns_has_Users();

	public void setIdCampaigns_has_Users(Integer idCampaigns_has_Users);

	public Campaign getCampaign();

	public void setCampaign(Campaign campaign);

	public User getUser();

	public void setUser(User user);
	
	public int getCampaigns_Score();
	
	public void setCampaigns_Score(int campaigns_Score);
	
}

