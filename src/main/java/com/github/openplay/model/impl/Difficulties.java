package com.github.openplay.model.impl;

import java.util.Date;
import java.util.HashSet;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.github.openplay.model.DifficultiesInterface;




import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Component
@XmlRootElement(name="difficulties")
@Entity
@Table(name="difficulties")
public class Difficulties implements DifficultiesInterface {
	
	@Id
	@GeneratedValue
	@Column(name="difficultyId")
	private Long difficultyId;
	
	@NotEmpty
	@Size(min=4, max=70)
	@Column(name="description")
	private String description;
	
	private Set<Mission> mission = new HashSet<Mission>(0);

	public Long getId() {
		return difficultyId;
	}

	public void setId(Long difficultyId) {
		this.difficultyId = difficultyId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "difficulty")
	public Set<Mission> getMission(){
		return this.mission;
	}

	public void setMission(Set<Mission> mission){
		this.mission = mission;
	}
}