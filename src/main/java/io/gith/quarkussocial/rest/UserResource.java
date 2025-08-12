package io.gith.quarkussocial.rest;

import io.gith.quarkussocial.domain.module.User;
import io.gith.quarkussocial.domain.repository.UserRepository;
import io.gith.quarkussocial.rest.dto.CreateUserRequest;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private final UserRepository repository;

    public UserResource(UserRepository repository){
        this.repository = repository;
    }

    @POST
    @Transactional
    public Response createUser( CreateUserRequest userRequest ){
        User user = new User();

        user.setAge(userRequest.getAge());
        user.setName(userRequest.getName());

        repository.persist(user);



        return  Response.ok(user).build();
    }

    @GET
    public Response listAllUsers(){
        PanacheQuery<User> query = repository.findAll();
        return Response.ok(query.list()).build();
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id ){
        User user = repository.findById(id);
        if (user != null){
            repository.delete(user);
            return Response.ok().build();



        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Transactional
    @Path("{id}")
    public Response updateUser(@PathParam("id") Long id, CreateUserRequest userData ){
        User user = repository.findById(id);
        if (user!=null){
            user.setName(userData.getName());
            user.setAge(userData.getAge());
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
