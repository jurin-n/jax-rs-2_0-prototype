package com.jurin_n.jaxrs.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

public class AuthenticateFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext arg0) throws IOException {
        System.out.println(this.getClass().getName() + "[filter(requestContext,responseContext)]");
        System.out.println("認証！！");
    }
}
