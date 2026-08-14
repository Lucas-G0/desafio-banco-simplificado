package com.desafio.bancosimplificadojava.service.transaction;

import com.desafio.bancosimplificadojava.dtos.CreateTransactionDTO;
import com.desafio.bancosimplificadojava.interfaces.ICreateTransactionService;
import com.desafio.bancosimplificadojava.model.transaction.Transaction;
import com.desafio.bancosimplificadojava.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionService implements ICreateTransactionService {
    @Autowired
    private TransactionRepository repository;

    @Override
    public CreateTransactionDTO CreateAndSave(CreateTransactionDTO createTransactionDTO) {
        Transaction transaction = new Transaction(createTransactionDTO);
        Transaction newTransaction = repository.save(transaction);
        return new CreateTransactionDTO(
                newTransaction.getSender(),
                newTransaction.getReceiver(),
                newTransaction.getAmount());
    }
}
