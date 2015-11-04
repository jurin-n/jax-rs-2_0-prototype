package com.jurin_n.rest;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jurin_n.entity.Team;
import com.jurin_n.services.TeamService;

@Path("/team")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource {
	  @EJB
	  TeamService ts;
	  
	  @POST
	  public Response createTeam(Team t){

		  //サービス
		  //TeamService ts = new TeamService();
		  System.out.println("[DEBUG] TeamResource.createTeam サービス前");
		  ts.createTeam(t);
		  System.out.println("[DEBUG] TeamResource.createTeam サービス後");
		  
		  System.out.println("[DEBUG] TeamResource.createTeam2 サービス前");
		  Team t2 = new Team();
		  t2.setId(t.getId()+"@createTeam2");
		  t2.setName(t.getName());
		  ts.createTeam2(t2);
		  System.out.println("[DEBUG] TeamResource.createTeam2 サービス後");
		  //レスポンス
		  return Response
				  .status(Response.Status.CREATED)
				  .build();
	  }
}
