package com.github.openplay.resource;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;

import com.github.openplay.model.impl.Badge;

public interface AdminResourceInterface {

	public Response signup();

	public Response signup(String emailAddress, String password, String firstName, String lastName,
			String birthdate, String phone, String country, String interest, String role)
			throws ParseException;

	public Response login();
	
	public Response badges();
	
	public Response createBadge(String badgeName, String badgeValue) throws ParseException ;

	public Response login(String userName, String password);
	
	public Response createComment();
	
	public List<Badge> showBadges();

	public Response createComment(String users_UserIdFrom, String users_UserIdTo, String date, String comment)throws ParseException; ;

}

