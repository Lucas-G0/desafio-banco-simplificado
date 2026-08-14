package com.desafio.bancosimplificadojava.interfaces;

import com.desafio.bancosimplificadojava.dtos.CreateUserDTO;
public interface ICreateUserService {
    Long CreateAndSave(CreateUserDTO createUserDTO);
}
