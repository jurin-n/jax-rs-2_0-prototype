package com.jurin_n.jaxrs.resources;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.ws.rs.core.Application;

import org.glassfish.hk2.utilities.Binder;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.jurin_n.domain.team.TeamService;
import com.jurin_n.jaxrs.filters.AuthenticateFeature;

import org.glassfish.hk2.api.Factory;

public class TeamResourceTest extends JerseyTest {

    @Test
    public void testHelloWorld() throws Exception {
        String response = target("/team/1").queryParam("name", "world")
                .request().get(String.class);
        assertThat(response, is("{\"id\":\"1\",\"name\":\"test1\"}"));
    }

    @Override
    protected Application configure() {
        Binder binder = new AbstractBinder() {
            @Override
            protected void configure() {
                // bindFactory() + to() でモックに差し替え
                bindFactory(TeamServiceFactory.class).to(TeamService.class);
            }
        };
        ResourceConfig config = new ResourceConfig(TeamResource.class,
                AuthenticateFeature.class);
        config.register(binder);
        return config;
    }

    /**
     * TeamServiceのモックのファクトリークラス
     */
    private static class TeamServiceFactory implements Factory<TeamService> {
        @Override
        public TeamService provide() {
            // TODO Mockitで対応
            return new TeamService();
        }

        @Override
        public void dispose(TeamService instance) {
            // 何もしない
        }
    }
}
