package io.gith.quarkussocial.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users/{userId}/posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostResource {

    @POST
    public Response SavePost(){
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response GetPost(){
        return Response.status(Response.Status.CREATED).build();
    }

}

