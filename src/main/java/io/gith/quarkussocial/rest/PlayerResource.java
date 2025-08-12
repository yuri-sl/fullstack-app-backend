package io.gith.quarkussocial.rest;


import io.gith.quarkussocial.rest.dto.CreatePlayerRequest;

import io.gith.quarkussocial.entidade.Player;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/player")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {

    @POST
    @Transactional
    public Response createPlayer(CreatePlayerRequest playerRequest){
        Player player = new Player();


        return  Response.ok(user).build();
    }
}
