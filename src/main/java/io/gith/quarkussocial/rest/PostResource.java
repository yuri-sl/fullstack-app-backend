package io.gith.quarkussocial.rest;

import io.gith.quarkussocial.domain.module.User;
import io.gith.quarkussocial.domain.repository.PostsRepository;
import io.gith.quarkussocial.domain.repository.UserRepository;
import io.gith.quarkussocial.entidade.Posts;
import io.gith.quarkussocial.rest.dto.CreatePostRequest;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;

@Path("/users/{userId}/posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostResource {
    private UserRepository userRepository;
    private PostsRepository postsRepository;
    @Inject
    public PostResource(UserRepository userRepository, PostsRepository postsRepository){
        this.userRepository = userRepository;
        this.postsRepository = postsRepository;
    }

    @POST
    @Transactional
    public Response SavePost(@PathParam("userId") Long userId, CreatePostRequest createPostDTO){
        User user = userRepository.findById(userId);
        if(user==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Posts post = new Posts();
        post.setPost_text(createPostDTO.getPost_text());
        post.setUser(user);
        post.setDate_time(LocalDateTime.now());

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response GetPost(@PathParam("userId") Long userId){
        User user = userRepository.findById(userId);
        if(user == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        PanacheQuery<Posts> query = postsRepository.find("user",user);
        //List<Posts> list = query.list();
        return Response.status(Response.Status.CREATED).build();
    }

}

