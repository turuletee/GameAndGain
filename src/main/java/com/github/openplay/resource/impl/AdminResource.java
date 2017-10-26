package com.github.openplay.resource.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.openplay.model.impl.User;
import com.github.openplay.resource.AdminResourceInterface;
import com.github.openplay.service.AdminService;

@Component
@Path("adminResource")
@XmlRootElement
public class AdminResource implements AdminResourceInterface {

	@Autowired
	private AdminService adminService; //reemplazar por el tag que se encuentra en AdminServiceImple : @Service("adminService")

	@GET
	@Path("signup2")
	@Produces(MediaType.TEXT_HTML)
	public Response signup2() {
		return Response.ok(new Viewable("/signup2")).build();
	}

	@POST
	@Path("signup2")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response signup2(@FormParam("emailAddress") String emailAddress,
			@FormParam("password") String password,
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("birthdate") String birthdate,
			@FormParam("phone") String phone,
			@FormParam("country") String country,
			@FormParam("interest") String interest,
			@FormParam("role") String role 
			)
			throws ParseException {

		if (emailAddress == null || password == null || firstName == null
				|| lastName == null || birthdate == null
				|| phone == null || country == null) {
			return Response.status(Status.PRECONDITION_FAILED).build();
		}

		User user = new User();
		user.setPassword(password);
		user.setName(firstName);
		user.setLastname(lastName);
		user.setMail(emailAddress);
		user.setPhone(phone);
		user.setCountry(country);
		user.setInterests_InterestId(Integer.parseInt(interest));
		user.setRoles_RoleId(Integer.parseInt(role));
		user.setBirthdate(new java.sql.Date(new SimpleDateFormat(
				"MM/dd/yyyy").parse(birthdate.substring(0, 10)).getTime()));


		if (adminService.findByUserName(emailAddress)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "User Name exists. Try another user name");
			map.put("student", user);
			return Response.status(Status.BAD_REQUEST)
					.entity(new Viewable("/signup2", map)).build();
		} else {
			adminService.save(user);
			return Response.ok().entity(new Viewable("/login2")).build();
		}
	}

	@GET
	@Path("login2")
	@Produces(MediaType.TEXT_HTML)
	public Response login2() {
		return Response.ok(new Viewable("/login2")).build();
	}

	@POST
	@Path("login2")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response login2(@FormParam("emailAddress") String emailAddress,
			@FormParam("password") String password) {

		if (emailAddress == null || password == null) {
			return Response.status(Status.PRECONDITION_FAILED).build();
		}

		boolean found = adminService.findByLogin(emailAddress, password);
		if (found) {
			return Response.ok().entity(new Viewable("/success")).build();
		} else {
			return Response.status(Status.BAD_REQUEST)
					.entity(new Viewable("/failure")).build();
		}
	}
}
