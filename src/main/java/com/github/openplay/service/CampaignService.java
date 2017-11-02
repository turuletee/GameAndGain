package com.github.openplay.service;
import java.util.List;
import com.github.openplay.model.impl.Campaign;

public interface CampaignService 
{
	
	public void createCampaign(Campaign campaign);
	public Campaign getCampaign(int id);
	public List<Campaign> getAllCampaigns();
	public void editCampaign(Campaign campaign);
	public void deleteCampaign(int id);
	
}