package com.desafio.bancosimplificadojava.service.user;

import com.desafio.bancosimplificadojava.interfaces.ISaveUserService;
import com.desafio.bancosimplificadojava.model.user.User;
import com.desafio.bancosimplificadojava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveUserService implements ISaveUserService {
    @Autowired
    private UserRepository repository;

    @Override
    public void SaveUser(User user) {
        repository.save(user);
    }

    @Override
    public void SaveUsers(List<User> users) {
        repository.saveAll(users);
    }
}
