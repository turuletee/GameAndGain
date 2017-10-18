package com.github.openplay.model.impl;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.github.openplay.model.InterestInterface;

@Component
@XmlRootElement(name="interests")
@Entity
@Table(name="interests")
public class Interest  implements InterestInterface {
	@Id
	@GeneratedValue
	private Long interestId;
	
	@NotEmpty
	private String description;

	public Long getInterestId() {
		return interestId;
	}

	public void setInterestId(Long interestId) {
		this.interestId = interestId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
