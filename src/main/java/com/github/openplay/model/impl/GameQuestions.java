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

import com.github.openplay.model.GameQuestionsInterface;


@Component
@XmlRootElement(name="game_questions")
@Entity
@Table(name="game_questions")

public class GameQuestions implements GameQuestionsInterface{
	
	@Id
	@GeneratedValue
	private Integer idGame_Questions;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="state_idState")
	private GameState gameState;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idCampaign")
	private Campaign camapaign;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idMission")
	private Mission mission;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idQuestion")
	private Question question;

	public Integer getIdGame_Questions() {
		return idGame_Questions;
	}

	public void setIdGame_Questions(Integer idGame_Questions) {
		this.idGame_Questions = idGame_Questions;
	}

	
	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}


	public Campaign getCamapaign() {
		return camapaign;
	}

	public void setCamapaign(Campaign camapaign) {
		this.camapaign = camapaign;
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}


}
