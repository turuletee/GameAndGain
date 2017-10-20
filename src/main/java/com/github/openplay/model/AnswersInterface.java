package com.github.openplay.model;

import java.util.Date;

import com.github.openplay.model.impl.Question;

public interface AnswersInterface{

	public int getId();

	public void setId(int answerId);

	public String getAnswer();

	public void setAnswer(String answer);

	public boolean getAnswerValue();

	public void setAnswerValue(Boolean answer_value);

	// Fk functions

	public Question getQuestions();

	public void setQuestions(Question question);

}

