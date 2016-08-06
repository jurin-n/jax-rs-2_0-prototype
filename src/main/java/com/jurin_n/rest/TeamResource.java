package com.jurin_n.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jurin_n.domain.team.Team;

@Path("/team")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource {
  
	  @GET
	  public Response getTeams(){

		  //レスポンス
		  return Response
				  .status(Response.Status.OK)
				  .entity(new Team("1","test"))
				  .build();
	  }
}
