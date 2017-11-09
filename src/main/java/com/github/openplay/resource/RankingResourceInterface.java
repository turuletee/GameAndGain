package com.github.openplay.resource;

import java.text.ParseException;

import javax.ws.rs.core.Response;

public interface RankingResourceInterface {
	
	public Response getRanking();
	
	public Response getRanking(String name) throws ParseException;

}
