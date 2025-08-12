package io.gith.quarkussocial.repositorio;

import io.gith.quarkussocial.entidade.Player;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlayerRepository implements PanacheRepository<Player> {

}
