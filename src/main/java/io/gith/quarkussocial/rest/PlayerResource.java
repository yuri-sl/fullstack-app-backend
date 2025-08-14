package io.gith.quarkussocial.rest;

import io.gith.quarkussocial.domain.module.User;
import io.gith.quarkussocial.repositorio.PlayerRepository;
import io.gith.quarkussocial.rest.dto.CreatePlayerRequest;
import io.gith.quarkussocial.entidade.Player;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
