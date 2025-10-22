package io.gith.quarkussocial.rest;

import io.gith.quarkussocial.domain.repository.ClienteRepository;
import io.gith.quarkussocial.entidade.Cliente;
import io.gith.quarkussocial.dto.Cliente.CreateClienteRequest;
import io.gith.quarkussocial.exception.BookStockManagerExceptions;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import io.gith.quarkussocial.dto.Cliente.CreateClienteResponse;
import lombok.Builder;

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Builder
public class ClienteResource {
    @Inject
    private final ClienteRepository repository;
    public ClienteResource(ClienteRepository repository){
        this.repository = repository;
    }

    @GET
    public Response listAllUsers(){
        PanacheQuery<Cliente> query = repository.findAll();
        return Response.ok(query.list()).build();
    }
    @POST
    @Transactional
    public Response createCliente(@Valid CreateClienteRequest dto, @Context UriInfo uriInfo){
        if (repository.existsByEmail(dto.email_cliente())){
            return Response.status(Response.Status.CONFLICT)
                    .entity(new ErrorPayload("E-mail já foi cadastrado"))
                    .build();
        }
        Cliente cliente = new Cliente();
        cliente.setNome_cliente(dto.nome_cliente());
        cliente.setEmail_cliente(dto.email_cliente());
        cliente.setSenha_cliente(dto.senha_cliente());
        cliente.setCpf_cliente(dto.cpf_cliente());

        repository.persist(cliente);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(String.valueOf(cliente.getId_cliente()));
        CreateClienteResponse body = new CreateClienteResponse(cliente.getId_cliente(), cliente.getNome_cliente(), cliente.getEmail_cliente());
        return  Response.created(builder.build()).entity(body).build();
        //return Response.ok(cliente).build();
    }
    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizarCliente(@PathParam("id") Long id_cliente, @Valid CreateClienteRequest dto,@Context UriInfo uriInfo){
        Cliente cliente = repository.findByIdOptional(id_cliente)
                .orElseThrow(() -> new WebApplicationException("Cliente não encontrado",404));

        cliente.setNome_cliente(dto.nome_cliente());
        cliente.setSenha_cliente(dto.senha_cliente());
        cliente.setCpf_cliente(dto.cpf_cliente());
        cliente.setEmail_cliente(dto.email_cliente());

        repository.persist(cliente);

        return Response.ok().build();
    }
    public record ErrorPayload(String message){}
}