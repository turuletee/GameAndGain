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

import com.github.openplay.model.CampaignInterface;


import com.github.openplay.model.impl.Mission;
import com.github.openplay.model.QuestionsInterface;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Component
@XmlRootElement(name="questions")
@Entity
@Table(name="questions")
public class Question implements QuestionsInterface {
	
	@Id
	@GeneratedValue
	@Column(name="questionId")
	private Long questionId;
	
	@NotEmpty
	@Size(min=4, max=20)
	private String question;
	

	@NotEmpty
	private Integer score;


	// Foreign keys association
	@NotNull
	@ManyToOne
	@JoinColumn(name="missionId")
	private Mission mission;
	
	private Set<Answers> answer = new HashSet<Answers>(0);
	
	public Long getId() {
		return questionId;
	}

	public void setId(Long questionId) {
		this.questionId = questionId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Mission getMission(){
		return mission;
	}

	public void setMission(Mission mission){
		this.mission = mission;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "question")
	public Set<Answers> getAnswers(){
		return answer;
	}

	public void setAnswer(Set<Answers> answer){
		this.answer = answer;
	}


}