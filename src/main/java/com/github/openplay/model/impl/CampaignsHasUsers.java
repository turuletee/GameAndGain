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
	private Campaign campaign;
	
	@NotNull
	private User user;

	public Integer getIdCampaigns_has_Users() {
		return idCampaigns_has_Users;
	}

	public void setIdCampaigns_has_Users(Integer idCampaigns_has_Users) {
		this.idCampaigns_has_Users = idCampaigns_has_Users;
	}

	@ManyToOne
	@JoinColumn(name = "campaignsId")
	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
}
