package io.gith.quarkussocial.rest;

import io.gith.quarkussocial.rest.dto.CreateUsuarioRequest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuario")
public class UsuarioTentativa {

    @POST
    public Response createUsuarioTentativaBuscar(CreateUsuarioRequest usuarioRequest){
        return Response.ok().build();

    }
}
