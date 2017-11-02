package com.github.openplay.resource.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.stereotype.Controller;

import com.github.openplay.service.CampaignService;
import com.github.openplay.model.impl.Campaign;

@Controller
@RequestMapping("/campaigns")
public class CampaignResource {
	
	@Autowired
	public CampaignService campaignServImpl;
	
	@RequestMapping(value="/create", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public void createCampaign(@RequestBody Campaign campaign){
		campaignServImpl.createCampaign(campaign);
	}

	
	@RequestMapping(value="/{id}", produces="application/json", method=RequestMethod.GET)
	@ResponseBody
	public Campaign getCampaginById(@PathVariable("id") int id){
		Campaign campaign= campaignServImpl.getCampaign(id);
		return campaign;
	}
	
	@RequestMapping(value="/list", produces="application/json", method=RequestMethod.GET)
	@ResponseBody
	public List<Campaign> getAllCampaigns(){
		List<Campaign> campaignList = campaignServImpl.getAllCampaigns();
		return campaignList;
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void editCampaign(@RequestBody Campaign campaign){
		campaignServImpl.editCampaign(campaign);
	}
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE, produces="application/json")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void deleteCampaign(@PathVariable("id") int id){
		campaignServImpl.deleteCampaign(id);
	}

}
