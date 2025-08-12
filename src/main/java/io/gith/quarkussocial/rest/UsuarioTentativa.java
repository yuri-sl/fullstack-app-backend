package io.gith.quarkussocial.rest;

import io.gith.quarkussocial.rest.dto.CreateUsuarioRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuario")
public class UsuarioTentativa {

    @POST
    public Response createUsuarioTentativaBuscar(CreateUsuarioRequest usuarioRequest){
        return Response.ok().build();

    }
}
