package com.desafio.bancosimplificadojava.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record GetTransactionDTO(
        @Schema(description = "Nome do recebedor") String payeeName,
        @Schema(description = "Valor transferido") BigDecimal value,
        @Schema(description = "Data da transferência")LocalDateTime dateTime
        ) {
}
