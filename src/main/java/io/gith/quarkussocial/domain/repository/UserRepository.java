package io.gith.quarkussocial.domain.repository;

import io.gith.quarkussocial.domain.module.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped//Scopo de aplicação.
public class UserRepository implements PanacheRepository<User> {

}
