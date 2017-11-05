package com.github.openplay.resource.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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

import com.github.openplay.model.CommentInterface;
import com.github.openplay.model.impl.Comment;
import com.github.openplay.resource.CommentResourceInterface;
import com.github.openplay.service.CommentService;

@Component
@Path("commentResource")
@XmlRootElement
public class CommentResource implements CommentResourceInterface {
	
	@Autowired
	private CommentService commentService; //reemplazar por el tag que se encuentra en CommentServiceImple : @Service("commentService")

	
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
		
		
		commentService.saveComment(newComment);
		return Response.ok().entity(new Viewable("/success")).build();
	}

	
	@POST
	@Path("temporalGetComment")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response getComment(@FormParam("users_UserIdTo") String users_UserIdTo)
			throws ParseException {

		if (users_UserIdTo == null) {
			return Response.status(Status.PRECONDITION_FAILED).build();
		}
		
		Comment c = (Comment) commentService.getComment(Integer.parseInt(users_UserIdTo));
		System.out.printf(c.getComment());
		
		return Response.ok().entity(new Viewable("/success")).build();
	}
	
}
