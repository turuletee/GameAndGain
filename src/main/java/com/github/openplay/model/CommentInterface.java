package com.github.openplay.model;

import java.util.Date;

public interface CommentInterface {

	public void createComment(int userIdFrom, int userIdTo, Date date, String comment);

	public String getComment(); 
}