package com.desafio.bancosimplificadojava.interfaces;

import com.desafio.bancosimplificadojava.dtos.GetTransactionDTO;
import com.desafio.bancosimplificadojava.exceptions.TransactionNotFoundException;
import com.desafio.bancosimplificadojava.model.transaction.Transaction;

import java.util.List;

public interface IGetTransactionService {
    GetTransactionDTO findById(long id) throws TransactionNotFoundException;
    List<GetTransactionDTO> findBySenderId(long senderId);
}
