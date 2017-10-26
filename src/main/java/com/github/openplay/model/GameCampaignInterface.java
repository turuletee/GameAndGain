package com.github.openplay.model;

import com.github.openplay.model.impl.Campaign;
import com.github.openplay.model.impl.GameState;
import com.github.openplay.model.impl.User;

public interface GameCampaignInterface {
	public Integer getIdGame_Campaign();

	public void setIdGame_Campaign(Integer idGame_Campaign);

	public GameState getGameState();

	public void setGameState(GameState gameState);

	public Campaign getCamapaign();

	public void setCamapaign(Campaign camapaign);

	public User getUser();

	public void setUser(User user);
}
