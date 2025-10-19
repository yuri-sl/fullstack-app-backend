package io.gith.quarkussocial.domain.repository;

import io.gith.quarkussocial.entidade.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {
    public boolean existsByEmail(String email){
        return count("email_cliente",email) >0;
    }

}
