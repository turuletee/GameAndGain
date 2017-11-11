package com.github.openplay.resource.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.github.openplay.model.impl.ProjectStates;
import com.github.openplay.service.ProjectService;


@Component
@Path("projectResource")
@XmlRootElement
public class ProjectResource {

	@Autowired ProjectService projectService;
	
	@GET
	@Path("getProjectState")
	@Produces(MediaType.TEXT_HTML)
	public Response getProjectState() {
		return Response.ok(new Viewable("/projectState")).build();
	}
	
	@POST
	@Path("getProjectState")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response getProjectState(@FormParam("nameProject") String nameProject)
			throws ParseException {

		if (nameProject == null) {
			return Response.status(Status.PRECONDITION_FAILED).build();
		}
		
		ProjectStates states = projectService.getState(nameProject);
		String state = states.getStatus();
		
		System.out.println("El estado de esta camapaña es: " + state);
		
		return Response.ok().entity(new Viewable("/success")).build();
	}
	
	@POST
	@Path("updateDonor")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response updateDonor(
			@FormParam("project") String project,
			@FormParam("name") String name,
			@FormParam("date") String date)
			throws ParseException {

		if (project == null || name == null) {
			return Response.status(Status.PRECONDITION_FAILED).build();
		}
		
		Date fecha = new java.sql.Date(new SimpleDateFormat("MM/dd/yyyy").parse(date).getTime());
		projectService.updateDonor(project, name, fecha);
		
		return Response.ok().entity(new Viewable("/success")).build();
	}

}
