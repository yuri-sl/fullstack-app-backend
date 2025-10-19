package io.gith.quarkussocial.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public record CreateClienteRequest (
    @NotBlank(message="Nome é requerido para criar um cliente")
    String nome_cliente,
    @NotBlank(message="Email do cliente é requerido para criar um novo cliente")
    @Email(message="Email inválido")
    String email_cliente,
    @NotBlank(message = "Senha é requerida")
    String senha_cliente
) {}
