package com.github.openplay.resource;

import java.text.ParseException;

import javax.ws.rs.core.Response;

public interface CommentResourceInterface {
	
	public Response createComment();

	public Response createComment(String users_UserIdFrom, String users_UserIdTo, String date, String comment)throws ParseException;
	
	public Response getComment(String users_UserIdTo)throws ParseException;

}
