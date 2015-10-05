package com.jurin_n.resource;

import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.core.MediaType;

@Path("/StreamingOutputResource")
public class StreamingOutputResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public StreamingOutput get(){
		return new StreamingOutput(){
			@Override
			public void write(OutputStream output) throws IOException{
				output.write("Streaming Output Resource!!!!".getBytes());
			}
		};
	}
}
