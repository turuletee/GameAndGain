package com.github.openplay.resource.impl;

import java.io.PrintWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.openplay.model.impl.Badge;
import com.github.openplay.model.impl.Comment;
import com.github.openplay.model.impl.User;
import com.github.openplay.resource.AdminResourceInterface;
import com.github.openplay.service.AdminService;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.servlet.ModelAndView;
import java.lang.Object;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GET
	@Path("badges")
	@Produces(MediaType.TEXT_HTML)
	public Response badges() {
		return Response.ok(new Viewable("/badges")).build();
	}
	
	@POST
	@Path("createBadge")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response createBadge(
			@FormParam("badgeName") String badgeName,
			@FormParam("badgeValue") String badgeValue)
			throws ParseException {
				if (badgeName == null) {
					return Response.status(Status.PRECONDITION_FAILED).build();
				}
		
				Badge newBadge = new Badge();
				newBadge.setName(badgeName);
				newBadge.setValue(Integer.parseInt(badgeValue));
								
				adminService.saveBadge(newBadge);
				return Response.ok().entity(new Viewable("/success")).build();
	}	
	
	@RequestMapping(value="#")
    public ModelAndView viewBadges(Model model) {
        Map<String, List<Badge>> badge =
                new HashMap<String, List<Badge>>();
       
        badge.put("badge", adminService.showBadges());
        System.out.println(new ModelAndView("badgeList", badge));
        return new ModelAndView("badgeList", badge);
        
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GET
	@Path("showBadges")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public List<Badge> showBadges(){
		List<Badge> badges = adminService.showBadges();
		for(int i = 0; i < badges.size(); i++) {
			System.out.println(badges.get(i).getBadgeId());
            System.out.println(badges.get(i).getName());
            System.out.println(badges.get(i).getValue()); 
        }
		//badges.addAttribute("badgeName", badges.get(0).getName());
		return badges;
	}

	@GET
	@Path("profile")
	@Produces(MediaType.TEXT_HTML)
	public Response profile() {
		return Response.ok(new Viewable("/profile")).build();
	}
		
	@POST
	@Path("updateBadge")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response updateBadge(
			
			@FormParam("update_badgeName") String badgeName,
			@FormParam("update_badgeValue") String badgeValue,
			@FormParam("update_badgeId") String badgeId)
			throws ParseException {
				if (badgeName == null||badgeId == null||badgeValue == null) {
					return Response.status(Status.PRECONDITION_FAILED).build();
				}
				Badge newBadge = new Badge();
				newBadge.setName(badgeName);
				newBadge.setValue(Integer.parseInt(badgeValue));
				newBadge.setBadgeId(Integer.parseInt(badgeId));
								
				adminService.updateBadge(newBadge);
				
				return Response.ok().entity(new Viewable("/success")).build();
	}	
	
	@POST
	@Path("deleteBadge")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response deleteBadge(
			@FormParam("delete_badgeId") String badgeId)
			throws ParseException {
				if (badgeId == null) {
					return Response.status(Status.PRECONDITION_FAILED).build();
				}

				adminService.deleteBadge(Integer.parseInt(badgeId));
				
				return Response.ok().entity(new Viewable("/success")).build();
	}	

}
