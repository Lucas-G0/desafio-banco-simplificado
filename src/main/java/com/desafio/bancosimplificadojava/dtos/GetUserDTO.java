package com.desafio.bancosimplificadojava.dtos;

import com.desafio.bancosimplificadojava.model.user.UserType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record GetUserDTO(
        @Schema(description = "Id do usuário") Long id,
        @Schema(description = "Nome completo") String fullName,
        @Schema(description = "CPF/CNPJ") String document,
        @Schema(description = "Tipo Comum/Lojista") UserType type,
        @Schema(description = "Email do usuário") String email,
        @Schema(description = "Saldo") BigDecimal balance
) { }