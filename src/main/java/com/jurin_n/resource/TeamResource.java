package com.jurin_n.resource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.jurin_n.entity.Team;

@Path("/team")
public class TeamResource {
	  @PersistenceContext
	  private EntityManager em;
	  
	  @POST
	  public Response createTeam(Team t){
		  em.merge(t);
		  return Response
				  .status(Response.Status.CREATED)
				  .build();
	  }
	  
	  @GET
	  @Path("{id}")
	  public Response createTeam(@PathParam("id") String id){
		  Team t = em.find(Team.class,id);
		  return Response
				  .status(Response.Status.OK)
				  .entity(t)
				  .build();
	  }
}
