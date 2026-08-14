package com.desafio.bancosimplificadojava.service.transaction;

import com.desafio.bancosimplificadojava.dtos.CreateTransactionDTO;
import com.desafio.bancosimplificadojava.interfaces.IAutorizadorTransferenciaService;
import com.desafio.bancosimplificadojava.interfaces.IValidateTransactionService;
import com.desafio.bancosimplificadojava.model.user.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateTransactionService implements IValidateTransactionService {
    @Autowired
    private IAutorizadorTransferenciaService autorizadorTransferenciaService;

    @Override
    public boolean Validate(CreateTransactionDTO createTransactionDTO) {
        if (createTransactionDTO.payer().getType() == UserType.MERCHANT)
            return false;

        if (createTransactionDTO.payer().getBalance().compareTo(createTransactionDTO.value()) < 0)
            return false;

        return autorizadorTransferenciaService.Authorize();
    }
}
