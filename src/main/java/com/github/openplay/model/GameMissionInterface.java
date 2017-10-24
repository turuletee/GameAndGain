package com.github.openplay.model;

import com.github.openplay.model.impl.Campaign;
import com.github.openplay.model.impl.GameState;
import com.github.openplay.model.impl.Mission;
import com.github.openplay.model.impl.User;

public interface GameMissionInterface {
	
	public Integer getIdGame_Questions();

	public void setIdGame_Questions(Integer idGame_Questions);

	public GameState getGameState();

	public void setGameState(GameState gameState);

	public Campaign getCamapaign() ;
	
	public void setCamapaign(Campaign camapaign);
	
	public User getUser();
	
	public void setUser(User user);

	public Mission getMission();
	
	public void setMission(Mission mission);
}
