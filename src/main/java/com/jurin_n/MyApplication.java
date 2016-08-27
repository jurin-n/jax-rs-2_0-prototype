package com.jurin_n;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.jurin_n.jaxrs.resources.TeamResource;

import io.swagger.jaxrs.config.BeanConfig;

/**
 * JAX-RS をロードするためのクラスです。
 */
@ApplicationPath("/")
public class MyApplication extends Application {

    public MyApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[] { "http" });
        beanConfig.setHost("localhost:9080");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("com.jurin_n.jaxrs");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();

        resources.add(TeamResource.class);
        // resources.add(SecondResource.class);
        // ...

        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }
}
