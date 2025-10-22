package io.gith.quarkussocial.rest;

import io.gith.quarkussocial.repositorio.PlayerRepository;
import io.gith.quarkussocial.dto.CreatePlayerRequest;
import io.gith.quarkussocial.entidade.Player;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/player")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {
    @Inject
    private final PlayerRepository repository;
    public PlayerResource(PlayerRepository repository){
        this.repository = repository;
    }

    @POST
    @Transactional
    public Response createPlayer(CreatePlayerRequest playerRequest){
        Player player = new Player();
        return  Response.ok(player).build();
    }
    @GET
    public Response listAllPlayers(){
        PanacheQuery<Player> query = repository.findAll();
        return Response.ok(query.list()).build();
    }
}
