package com.desafio.bancosimplificadojava.dtos;

import com.desafio.bancosimplificadojava.model.user.User;

import java.math.BigDecimal;

public record CreateTransactionDTO(User payer, User payee, BigDecimal value) {
}
