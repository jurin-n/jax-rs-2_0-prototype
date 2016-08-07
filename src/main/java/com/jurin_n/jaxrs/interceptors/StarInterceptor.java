package com.jurin_n.jaxrs.interceptors;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

@Provider
public class StarInterceptor implements ReaderInterceptor, WriterInterceptor  {

    @Override
    public void aroundWriteTo(WriterInterceptorContext context)
            throws IOException, WebApplicationException {
        System.out.println(this.getClass().getName() + "[aroundWriteTo]");
        context.proceed();
    }

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context)
            throws IOException, WebApplicationException {
        System.out.println(this.getClass().getName() + "[aroundReadFrom]");
        return context.proceed();
    }
}
