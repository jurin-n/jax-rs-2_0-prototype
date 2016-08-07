package com.jurin_n.jaxrs.resources;

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
    @MaxAge(value = 1000)
    public Response getTeams() {
        System.out.println(this.getClass().getName() + "[getTeams]");
        // レスポンス
        return Response.status(Response.Status.OK)
                .entity(new Team("2", "test2")).build();
    }

    @GET
    @Path("/1")
    public Response getTeam() {
        System.out.println(this.getClass().getName() + "[getTeam]");
        // レスポンス
        return Response.status(Response.Status.OK)
                .entity(new Team("1", "test1")).build();
    }
}
