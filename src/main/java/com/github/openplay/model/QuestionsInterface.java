package com.github.openplay.model;

import java.util.Date;

import com.github.openplay.model.impl.Mission;

public interface QuestionsInterface {

	public int getId();

	public void setId(int questionId);

	public Integer getScore();

	public void setScore(Integer score);

	public String getQuestion();

	public void setQuestion(String question);

	// Fk functions

	public Mission getMission();

	public void setMission(Mission mission);

}

