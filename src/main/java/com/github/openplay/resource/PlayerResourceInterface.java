package com.github.openplay.resource;

import java.text.ParseException;

import javax.ws.rs.core.Response;

public interface PlayerResourceInterface {
	public Response registerCampaign(String idUser, String idCampaign) throws ParseException;

}
