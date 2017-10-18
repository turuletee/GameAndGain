package com.github.openplay.model.impl;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.github.openplay.model.CampaignInterface;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Component
@XmlRootElement(name="campaign")
@Entity
@Table(name="campaign")
public class Campaign implements CampaignInterface {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	@Size(min=4, max=20)
	private String name;
	
	@NotEmpty
	private String description;
	
	private int maxScore;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date startDate;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date endDate;

	// Foreign keys association
	@NotNull
	private CampaignState campaignState
	
	@NotNull
	private CampaignType campaignType
	
	@NotNull
	private User users
	
	@NotNull
	private Project project
	
	@NotNull
	private Interest interest

	// Missing Foreign keys and foreign keys methods

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	//  Foreign keys functions

	@ManyToOne
	@JoinColumn(name='campaign_states')
	public CampaignState getCampaignState(){
		return campaignState;
	}

	public void setCampaignState(CampaignState campaignState){
		this.campaignState = campaignState;
	}

	@ManyToOne
	@JoinColumn(name='campaign_types')
	public CampaignType getCampaignType(){
		return campaignType;
	}

	public void setType(CampaignType campaignType){
		this.campaignType = campaignType;
	}

	@ManyToOne
	@JoinColumn(name='interests')
	public Interest getInterest(){
		return interest;
	}

	public void setInterest(Interest interest){
		this.interest = interest
	}

	@ManyToOne
	@JoinColumn(name='users')
	public User getUser(){
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name='projects')
	public Project getProject(){
		return project;
	}

	public void setProject(Project project){
		this.project = project
	}



}