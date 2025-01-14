package com.Wilson.Carrinho.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank(message = "Nome está vazio")
        String name,

        @NotBlank(message = "Email está vazio")
        String email,

        @NotBlank(message = "Senha está vazio")
        String password
) {
}
