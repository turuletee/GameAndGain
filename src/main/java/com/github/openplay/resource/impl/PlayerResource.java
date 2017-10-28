package com.github.openplay.resource.impl;

import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
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

import com.github.openplay.model.impl.Campaign;
import com.github.openplay.model.impl.CampaignsHasUsers;
import com.github.openplay.model.impl.User;
import com.github.openplay.resource.PlayerResourceInterface;
import com.github.openplay.service.impl.PlayerServiceImpl;

@Component
@Path("playerResource")
@XmlRootElement
public class PlayerResource implements PlayerResourceInterface{

	@Autowired
	private PlayerServiceImpl playerServiceImpl; 
	
	@POST
	@Path("registerCampaign")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response registerCmapaign(@FormParam("idUser") String idUser ,
			@FormParam("idCampaign") String idCampaign)
			throws ParseException {

		if (idUser == null || idCampaign == null ) {
			return Response.status(Status.PRECONDITION_FAILED).build();
		}
		
		Integer idUserint = new Integer (idUser);
		Integer idCampaingInt=new Integer(idCampaign);
		
		Campaign campaign = new Campaign();
		campaign.setId(idCampaingInt.intValue());
		
		User user = new User();
		user.setUserId(idUserint.intValue());
		
		CampaignsHasUsers campaignsHasUsers = new CampaignsHasUsers();
		campaignsHasUsers.setCampaign(campaign);
		
		
		playerServiceImpl.save(campaignsHasUsers);
		
		return Response.ok().entity(new Viewable("/login")).build();
	}
}
