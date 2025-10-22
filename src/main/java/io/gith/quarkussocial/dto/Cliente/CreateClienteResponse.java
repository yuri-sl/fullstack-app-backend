package io.gith.quarkussocial.dto.Cliente;

public record CreateClienteResponse (    Long id_cliente,
                                         String nome_cliente,
                                         String email_cliente)
{ }
