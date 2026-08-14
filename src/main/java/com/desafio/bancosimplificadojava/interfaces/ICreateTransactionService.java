package com.desafio.bancosimplificadojava.interfaces;

import com.desafio.bancosimplificadojava.dtos.CreateTransactionDTO;

public interface ICreateTransactionService {
    CreateTransactionDTO CreateAndSave(CreateTransactionDTO createTransactionDTO);
}
