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

import com.github.openplay.model.AnswersInterface;
import com.github.openplay.model.CampaignInterface;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Component
@XmlRootElement(name="answers")
@Entity
@Table(name="answers")
public class Answers implements AnswersInterface {
	
	@Id
	@GeneratedValue
	@Column(name="answerId")
	private int answerId;
	
	@NotEmpty
	@Size(min=4, max=40)
	private String answer;

	@NotEmpty
	@Column(name="answer_Value", columnDefinition = "BIT", length = 1)
	private boolean answer_value;
	
	// Foreign keys association
	@NotNull
	@ManyToOne
	@JoinColumn(name="questions_QuestionId")
	private Question question;
	

	public int getId() {
		return answerId;
	}

	public void setId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean getAnswerValue() {
		return answer_value;
	}

	public void setAnswerValue(Boolean answer_value) {
		this.answer_value = answer_value;
	}
	
	public Question getQuestions(){
		return question;
	}

	public void setQuestions(Question question){
		this.question = question;
	}


}