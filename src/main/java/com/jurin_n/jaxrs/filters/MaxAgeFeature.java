package com.jurin_n.jaxrs.filters;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

import com.jurin_n.jaxrs.resources.MaxAge;

@Provider
public class MaxAgeFeature implements DynamicFeature {

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext featureContext) {
        System.out.println(this.getClass().getName() + "[configure(resourceInfo,featureContext)]");
        MaxAge max = resourceInfo.getResourceMethod().getAnnotation(MaxAge.class);
        if(max == null){
            return;
        }
        featureContext.register(new CacheControlFilter(max.value()));
    }
}
