package com.desafio.bancosimplificadojava.service.user;

import com.desafio.bancosimplificadojava.dtos.GetUserDTO;
import com.desafio.bancosimplificadojava.exceptions.UserNotFoundException;
import com.desafio.bancosimplificadojava.interfaces.IGetUserService;
import com.desafio.bancosimplificadojava.model.user.User;
import com.desafio.bancosimplificadojava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserService implements IGetUserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Long id) throws UserNotFoundException {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public GetUserDTO getUserDTOById(Long id) throws UserNotFoundException {
        var user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return new GetUserDTO(
                user.getId(),
                user.getFullName(),
                user.getDocument(),
                user.getType(),
                user.getEmail(),
                user.getBalance()
        );
    }

    @Override
    public List<GetUserDTO> findAll(){
        List<User> users = repository.findAll();
        return users.stream().map((user) -> new GetUserDTO(
                user.getId(),
                user.getFullName(),
                user.getDocument(),
                user.getType(),
                user.getEmail(),
                user.getBalance()
        )).toList();
    }
}
