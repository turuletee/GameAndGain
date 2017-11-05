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

import com.github.openplay.model.impl.Comment;
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
	@Path("signup")
	@Produces(MediaType.TEXT_HTML)
	public Response signup() {
		return Response.ok(new Viewable("/signup")).build();
	}

	@POST
	@Path("signup")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response signup(@FormParam("emailAddress") String emailAddress,
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
		user.setBirthdate(new java.sql.Date(new SimpleDateFormat("MM/dd/yyyy").parse(birthdate).getTime()));


		if (adminService.findByUserName(emailAddress)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "User Name exists. Try another user name");
			map.put("student", user);
			return Response.status(Status.BAD_REQUEST)
					.entity(new Viewable("/signup", map)).build();
		} else {
			adminService.save(user);
			return Response.ok().entity(new Viewable("/login")).build();
		}
	}

	@GET
	@Path("login")
	@Produces(MediaType.TEXT_HTML)
	public Response login() {
		return Response.ok(new Viewable("/login")).build();
	}

	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response login(@FormParam("emailAddress") String emailAddress, @FormParam("password") String password) {

		if (emailAddress == null || password == null) {
			return Response.status(Status.PRECONDITION_FAILED).build();
		}

		boolean found = adminService.findByLogin(emailAddress, password);
		if (found) {
			int valor = adminService.findByUserRoleId(emailAddress);
			
			if (valor==1){
			return Response.ok().entity(new Viewable("/success")).build();
		}else if(valor==2){
				return Response.ok().entity(new Viewable("/donor")).build();
			}else if(valor==3){
				return Response.ok().entity(new Viewable("/beneficiary")).build();
			}else if(valor==4){
					return Response.ok().entity(new Viewable("/campaign_manager")).build();
				}else {
				return Response.status(Status.BAD_REQUEST).entity(new Viewable("/failure")).build();
			}
			}else {
				return Response.status(Status.BAD_REQUEST).entity(new Viewable("/failure")).build();
			}
	}
	
	@GET
	@Path("temporalComment")
	@Produces(MediaType.TEXT_HTML)
	public Response createComment() {
		return Response.ok(new Viewable("/TemporalComment")).build();
	}
	
	@POST
	@Path("temporalComment")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response createComment(
			@FormParam("users_UserIdFrom") String users_UserIdFrom,
			@FormParam("users_UserIdTo") String users_UserIdTo,
			@FormParam("date") String date,
			@FormParam("comment") String comment
			)
			throws ParseException {

		if (users_UserIdFrom == null || users_UserIdTo == null || date == null
				|| comment == null) {
			return Response.status(Status.PRECONDITION_FAILED).build();
		}

		Comment newComment = new Comment();


		newComment.setUsers_userIdFrom(Integer.parseInt(users_UserIdFrom));
		newComment.setUsers_userIdTo(Integer.parseInt(users_UserIdTo));
		newComment.setDate(new java.sql.Date(new SimpleDateFormat("MM/dd/yyyy").parse(date).getTime()));
		newComment.setComment(comment);
		
		
		adminService.saveComment(newComment);
		return Response.ok().entity(new Viewable("/success")).build();
	}

	
}
