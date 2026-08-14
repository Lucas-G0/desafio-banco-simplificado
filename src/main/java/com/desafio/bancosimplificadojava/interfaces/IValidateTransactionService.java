package com.desafio.bancosimplificadojava.interfaces;

import com.desafio.bancosimplificadojava.dtos.CreateTransactionDTO;

public interface IValidateTransactionService {
    boolean Validate(CreateTransactionDTO createTransactionDTO);
}
