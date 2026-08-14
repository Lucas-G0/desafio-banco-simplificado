package com.desafio.bancosimplificadojava.dtos;


import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record SendTransactionDTO(
        @Schema(description = "ID de quem paga") Long payer,
        @Schema(description = "ID de quem recebe") Long payee,
        @Schema(description = "Valor da transação") BigDecimal value
) { }
