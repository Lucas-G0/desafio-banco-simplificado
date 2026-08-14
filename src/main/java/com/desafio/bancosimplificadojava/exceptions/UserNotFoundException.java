package com.desafio.bancosimplificadojava.exceptions;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(Long id) {
        super("Usuário com o id " + id + " não encontrado");
    }
}
