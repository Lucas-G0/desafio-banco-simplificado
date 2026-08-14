package com.desafio.bancosimplificadojava.dtos;

import com.desafio.bancosimplificadojava.model.user.UserType;
import io.swagger.v3.oas.annotations.media.Schema;

public record CreateUserDTO(
        @Schema(description = "Primeiro nome") String firstName,
        @Schema(description = "Último nome") String lastName,
        @Schema(description = "CPF/CNPJ") String document,
        @Schema(description = "Tipo Comum/Lojista") UserType type,
        @Schema(description = "Email do usuário") String email,
        @Schema(description = "Senha do usuário") String password
) { }
