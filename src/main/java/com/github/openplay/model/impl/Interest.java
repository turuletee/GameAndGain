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
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.github.openplay.model.impl.Campaign;

@Component
@XmlRootElement(name="interests")
@Entity
@Table(name="interests")
public class Interest implements InterestInterface {
	
	@Id
	@GeneratedValue
	private Long interestId;
	
	@NotEmpty
	private String description;
	private Set<Campaign> campaign = new HashSet<Campaign>(0);


	public Interest(String description){
		this.description = description;
	}

	public Long getId(){
		return interestId;
	}

	public void setId(Long id) {
		this.interestId = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "interest")
	public Set<Campaign> getCampaign(){
		return campaign;
	}

	public void setCampaign(Set<Campaign> campaign){
		this.campaign = campaign;
	}
}