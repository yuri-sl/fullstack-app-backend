package io.gith.quarkussocial.domain.repository;

import io.gith.quarkussocial.entidade.Posts;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostsRepository implements PanacheRepository<Posts> {
}
