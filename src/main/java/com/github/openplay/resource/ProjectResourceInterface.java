package com.github.openplay.resource;

import javax.ws.rs.core.Response;

public interface ProjectResourceInterface {
	
	public Response getProjectState();
	
	public Response getProjectState(String nameProject);

}
