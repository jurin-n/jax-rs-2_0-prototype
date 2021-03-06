package com.jurin_n.jaxrs.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jurin_n.domain.team.Team;
import com.jurin_n.domain.team.TeamService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(TeamResource.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = TeamResource.PATH, description = "国に関する操作")
public class TeamResource {
    static final String PATH = "/team";

    @Inject
    TeamService service;

    public TeamResource(TeamService teamService) {
        super();
        service = teamService;
    }

    public TeamResource() {
        super();
    }

    @GET
    @MaxAge(value = 1000)
    @ApiOperation(value = "すべての国情報を取得", notes = "xx", response = Team.class, code = 200)
    public Response getTeams() {
        System.out.println(this.getClass().getName() + "[getTeams]");
        Team team = service.getTeams();

        // レスポンス
        return Response.status(Response.Status.OK).entity(team).build();
    }

    @GET
    @Path("/1")
    public Response getTeam() {
        System.out.println(this.getClass().getName() + "[getTeam]");
        Team team = service.getTeam();

        // レスポンス
        return Response.status(Response.Status.OK).entity(team).build();
    }
}
