package com.github.openplay.resource;

import java.text.ParseException;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;

public interface AdminResourceInterface {

	public Response signup2();

	public Response signup2(String emailAddress, String password, String firstName, String lastName,
			String birthdate, String phone, String country, String interest, String role)
			throws ParseException;

	public Response login2();

	public Response login2(String userName, String password);

}