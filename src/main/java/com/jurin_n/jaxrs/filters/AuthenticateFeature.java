package com.jurin_n.jaxrs.filters;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticateFeature implements DynamicFeature {

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext featureContext) {
        System.out.println(this.getClass().getName() + "[configure(resourceInfo,featureContext)]");
        featureContext.register(new AuthenticateFilter());
    }
}
