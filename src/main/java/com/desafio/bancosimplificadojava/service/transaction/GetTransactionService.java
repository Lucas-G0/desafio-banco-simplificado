package com.desafio.bancosimplificadojava.service.transaction;

import com.desafio.bancosimplificadojava.dtos.GetTransactionDTO;
import com.desafio.bancosimplificadojava.exceptions.TransactionNotFoundException;
import com.desafio.bancosimplificadojava.interfaces.IGetTransactionService;
import com.desafio.bancosimplificadojava.model.transaction.Transaction;
import com.desafio.bancosimplificadojava.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTransactionService implements IGetTransactionService {
    @Autowired
    private TransactionRepository repository;

    @Override
    public GetTransactionDTO findById(long id) throws TransactionNotFoundException {
        var transaction = repository.findById(id).orElseThrow(() -> new TransactionNotFoundException(id));
        return new GetTransactionDTO(
                transaction.getReceiver().getFullName(),
                transaction.getAmount(),
                transaction.getDate()
        );
    }

    @Override
    public List<GetTransactionDTO> findBySenderId(long senderId) {
        var transactions = repository.findBySenderId(senderId);
        return transactions.stream().map((transaction) -> new GetTransactionDTO(
                transaction.getReceiver().getFullName(),
                transaction.getAmount(),
                transaction.getDate()
        )).toList();
    }
}
