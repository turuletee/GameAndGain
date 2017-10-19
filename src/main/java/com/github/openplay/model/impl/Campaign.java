package com.github.openplay.model.impl;

import java.util.Date;
import java.util.HashSet;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.sessions.Project;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.github.openplay.model.CampaignInterface;
import com.github.openplay.model.impl.Interest;
import com.github.openplay.model.impl.CampaignStates;
import com.github.openplay.model.impl.CampaignTypes;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Component
@XmlRootElement(name="campaigns")
@Entity
@Table(name="campaigns")
public class Campaign implements CampaignInterface {
	@Id
	@Column(name="campaignsId")
	@GeneratedValue
	private Long campaignsId;
	
	@NotEmpty
	@Column(name="name")
	@Size(min=4, max=70)
	private String name;
	
	@NotEmpty
	@Column(name="description")
	@Size(min=4, max=300)
	private String description;
	
	@Column(name="maxScore")
	private Integer maxScore;
	
	@NotNull
	@Past
	@Column(name="startDate")
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date startDate;
	
	@NotNull
	@Past
	@Column(name="endDate")
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date endDate;

	// Foreign keys association
	@NotNull
	@ManyToOne
	@JoinColumn(name="campaign_States_Campaign_StateId")
	private CampaignStates campaignState;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="campaign_Types_Campaign_TypeId")
	private CampaignTypes campaignType;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="user_userId")
	private User users;
	
	
	private Set<Mission>mission= new HashSet<Mission>(0);
	// @NotNull
	// private Project project
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="interests_InterestsId")
	private Interest interest;

	// Missing Foreign keys and foreign keys methods

	public Long getId() {
		return campaignsId;
	}

	public void setId(Long campaignsId) {
		this.campaignsId = campaignsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(Integer maxScore) {
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

	public CampaignStates getCampaignState(){
		return campaignState;
	}

	public void setCampaignState(CampaignStates campaignState){
		this.campaignState = campaignState;
	}

	public CampaignTypes getCampaignType(){
		return campaignType;
	}

	public void setType(CampaignTypes campaignType){
		this.campaignType = campaignType;
	}

	
	public Interest getInterest(){
		return interest;
	}

	public void setInterest(Interest interest){
		this.interest = interest;
	}

	@ManyToOne
	@JoinColumn(name="users")
	public User getUser(){
		return users;
	}

	public void setUser(User user){
		this.users = user;
	}

	//@ManyToOne
	//@JoinColumn(name="projects")
	//public Project getProject(){
	//	return projects;
	//}

	//public void setProject(Project project){
	//	this.project = project;
	//}

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "campaign")
	public Set<Mission> getMission(){
		return this.mission;
	}

	public void setMission(Set<Mission> mission){
		this.mission = mission;
	}

}