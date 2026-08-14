package com.desafio.bancosimplificadojava.exceptions;

public class TransactionNotFoundException extends NotFoundException {
    public TransactionNotFoundException(Long id) {
        super("Transferência com o id " + id + " não encontrada.");
    }
}
