package com.github.openplay.model.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.github.openplay.model.CampaignStatesInterface;

@Component
@XmlRootElement(name="campaign_states")
@Entity
@Table(name="campaign_states")
public class CampaignStates implements CampaignStatesInterface{
	
	@Id
	@GeneratedValue
	@Column(name="campaign_StateId")
	private Long campaign_StateId;
	
	@NotEmpty
	@Column(name="description")
	private String description;
	
	private Set<Campaign> campaign = new HashSet<Campaign>(0);
	
	public Long getId() {
		return campaign_StateId;
	}

	public void setId(Long campaign_StateId) {
		this.campaign_StateId = campaign_StateId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "campaignState")
	public Set<Campaign> getCampaigns(){
		return this.campaign;
	 }
	 
	 public void setCampaign(Set<Campaign> campaign){
		 this.campaign = campaign;
	 }
}
