package com.github.openplay.resource.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.stereotype.Component;

import com.github.openplay.resource.CommonResourceInterface;

@Component
@Path("commonResource")
@XmlRootElement
public class CommonResource implements CommonResourceInterface {

	@GET
	@Path("rankingGeneral")
	@Produces(MediaType.TEXT_HTML)
	public Response getGeneralRanking(String userName) {	
		// TODO Auto-generated method stub
			return Response.ok(new Viewable("/common/awards")).build();
	}
}
