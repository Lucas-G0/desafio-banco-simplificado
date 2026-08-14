package com.desafio.bancosimplificadojava.interfaces;

import com.desafio.bancosimplificadojava.dtos.GetUserDTO;
import com.desafio.bancosimplificadojava.exceptions.UserNotFoundException;
import com.desafio.bancosimplificadojava.model.user.User;

import java.util.List;

public interface IGetUserService {
    User findById(Long id) throws UserNotFoundException;
    GetUserDTO getUserDTOById(Long id) throws UserNotFoundException;
    List<GetUserDTO> findAll();
}
