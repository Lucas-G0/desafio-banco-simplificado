package com.desafio.bancosimplificadojava.interfaces;

import com.desafio.bancosimplificadojava.dtos.SendTransactionDTO;

public interface ISendTransactionService {
    SendTransactionDTO Send(SendTransactionDTO dto) throws Exception;
}
