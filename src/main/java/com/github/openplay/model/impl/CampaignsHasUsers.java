package com.github.openplay.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.github.openplay.model.CampaingsHasUsersInterface;


@Component
@XmlRootElement(name="campaigns_has_users")
@Entity
@Table(name="campaigns_has_users")

public class CampaignsHasUsers implements CampaingsHasUsersInterface{

	@Id
	@GeneratedValue
	private Integer idCampaigns_has_Users;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "campaigns_CampaignsId")
	private Campaign campaign;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="users_UserId")
	private User user;
	
	@NotNull
	private int campaigns_Score;

	public Integer getIdCampaigns_has_Users() {
		return idCampaigns_has_Users;
	}

	public void setIdCampaigns_has_Users(Integer idCampaigns_has_Users) {
		this.idCampaigns_has_Users = idCampaigns_has_Users;
	}

	
	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public int getCampaigns_Score(){
		return campaigns_Score;
	}
	
	public void setCampaigns_Score(int campaigns_Score) {
		this.campaigns_Score = campaigns_Score;
	}
		
}
