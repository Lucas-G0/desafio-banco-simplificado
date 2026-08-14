package com.desafio.bancosimplificadojava.interfaces;

import com.desafio.bancosimplificadojava.model.user.User;

import java.util.List;

public interface ISaveUserService {
    void SaveUser(User user);
    void SaveUsers(List<User> users);
}
