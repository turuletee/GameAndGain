package com.github.openplay.model;

import java.util.Date;

import com.github.openplay.model.impl.User;

public interface CommentInterface {

	public int getCommentId();

	public void setCommentId(int commentId);

	public Date getDate();

	public void setDate(Date date);

	public String getComment();

	public void setComment(String comment);

	public Long getUsers_UserIdFrom();

	public void setUsers_UserIdFrom(Long users_UserIdFrom);

	public Long getUsers_UserIdTo();

	public void setUsers_UserIdTo(Long users_UserIdTo);

	public User getUserfrom();

	public void setUserfrom(User userfrom);

	public User getUserto();

	public void setUserto(User userto); 
}