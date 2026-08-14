package com.desafio.bancosimplificadojava.service.transaction;

import com.desafio.bancosimplificadojava.dtos.CreateTransactionDTO;
import com.desafio.bancosimplificadojava.dtos.SendTransactionDTO;
import com.desafio.bancosimplificadojava.interfaces.*;
import com.desafio.bancosimplificadojava.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendTransactionService implements ISendTransactionService {
    @Autowired
    private ICreateTransactionService createTransactionService;
    @Autowired
    private IValidateTransactionService validateTransactionService;
    @Autowired
    private INotificationService notificationService;
    @Autowired
    private IGetUserService getUserService;
    @Autowired
    private ISaveUserService saveUserService;

    @Override
    public SendTransactionDTO Send(SendTransactionDTO dto) throws Exception {
        User payer = getUserService.findById(dto.payer());
        User payee = getUserService.findById(dto.payee());

        CreateTransactionDTO createTransaction = new CreateTransactionDTO(payer, payee, dto.value());
        boolean transactionIsValid = validateTransactionService.Validate(createTransaction);
        if (!transactionIsValid) {
            throw new Exception("Erro ao validar os dados da transferência!");
        }

        CreateTransactionDTO newTransaction = createTransactionService.CreateAndSave(createTransaction);
        payer.decreaseBalance(newTransaction.value());
        payee.increaseBalance(newTransaction.value());

        saveUserService.SaveUsers(List.of(payer, payee));

        notificationService.sendNotification(payer, "Transação enviada com sucesso!");
        notificationService.sendNotification(payee, "Transação recebida com sucesso!");

        return new SendTransactionDTO(newTransaction.payer().getId(), newTransaction.payee().getId(), newTransaction.value());
    }
}
