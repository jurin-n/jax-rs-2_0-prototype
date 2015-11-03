package com.jurin_n.rest;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jurin_n.entity.Team;

@Stateless
@Path("/team2")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource2 {
	  @PersistenceContext
	  private EntityManager em;
	  
	  @POST
	  public Response createTeam(Team t){
		  em.persist(t);
		  return Response
				  .status(Response.Status.CREATED)
				  .build();
	  }
	  
	  @GET
	  @Path("/0/{id}")
	  public Response createTeam(@PathParam("id") String id){
		  /*
		  try {
			Thread.sleep(5000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  */
		  Team t = em.find(Team.class,id);
		  return Response
				  .status(Response.Status.OK)
				  .entity(t)
				  .build();
	  }
	  
	  @GET
	  @Path("/1/{id}")
	  public Response createTeam2(@PathParam("id") String id){
		  Team t = em.find(Team.class,id);
		  return Response
				  .status(Response.Status.OK)
				  .entity(t)
				  .build();
	  }
}
