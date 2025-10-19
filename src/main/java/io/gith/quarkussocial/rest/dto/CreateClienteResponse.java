package io.gith.quarkussocial.rest.dto;

public record CreateClienteResponse (    Long id_cliente,
                                         String nome_cliente,
                                         String email_cliente)
{ }
