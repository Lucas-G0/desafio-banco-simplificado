package com.desafio.bancosimplificadojava.service.user;

import com.desafio.bancosimplificadojava.dtos.CreateUserDTO;
import com.desafio.bancosimplificadojava.interfaces.ICreateUserService;
import com.desafio.bancosimplificadojava.model.user.User;
import com.desafio.bancosimplificadojava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements ICreateUserService {
    @Autowired
    private UserRepository repository;

    @Override
    public Long CreateAndSave(CreateUserDTO createUserDTO) {
        User user = new User(createUserDTO);
        repository.save(user);
        return user.getId();
    }
}
