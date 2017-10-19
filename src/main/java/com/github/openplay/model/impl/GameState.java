package com.github.openplay.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.github.openplay.model.GameStateInterface;

@Component
@XmlRootElement(name="game_state")
@Entity
@Table(name="game_state")

public class GameState implements GameStateInterface {
	
	@Id
	@GeneratedValue
	private Integer idState;
	
	@NotEmpty
	private String state;

	public Integer getIdState() {
		return idState;
	}

	public void setIdState(Integer idState) {
		this.idState = idState;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}	
}
