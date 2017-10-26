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

import com.github.openplay.model.GameCampaignInterface;

@Component
@XmlRootElement(name="game_campaign")
@Entity
@Table(name="game_campaign")
public class GameCampaign implements GameCampaignInterface {
	
	@Id
	@GeneratedValue
	private Integer idGame_Campaign;
	
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

	public Integer getIdGame_Campaign() {
		return idGame_Campaign;
	}

	public void setIdGame_Campaign(Integer idGame_Campaign) {
		this.idGame_Campaign = idGame_Campaign;
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

}
