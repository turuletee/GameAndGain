package com.github.openplay.model;

import java.util.Date;

import com.github.openplay.model.impl.User;

public interface CommentInterface {

	public int getCommentId();

	public void setCommentId(int commentId);

	public int getUsers_userIdFrom();

	public void setUsers_userIdFrom(int users_UserIdFrom);

	public int getUsers_userIdTo();

	public void setUsers_userIdTo(int users_UserIdTo);

	public String getComment();

	public void setComment(String comment);

	public Date getDate();

	public void setDate(Date date);
	
	/*
	 	public User getUserfrom();

	public void setUserfrom(User userfrom);

	public User getUserto();

	public void setUserto(User userto); 
	 */
	
}
