package com.github.openplay.model.impl;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.github.openplay.model.InterestInterface;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Component
@XmlRootElement(name="interest")
@Entity
@Table(name="interest")
public class Campaign implements CampaignInterface {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String description;
	private Set<Campaign> campaign;

	public Interest(){

	}

	public Interest(String description){
		this.description = description;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(mappedBy = 'interest')
	public Set<Campaign> getCampaigns(){
		return campaign;
	}

	public void setCampaign(Set<Campaign> campaign){
		this.campaign = campaign;
	}
}
