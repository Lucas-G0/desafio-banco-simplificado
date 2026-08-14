package com.desafio.bancosimplificadojava.interfaces;

import com.desafio.bancosimplificadojava.model.user.User;

public interface INotificationService {
    void sendNotification(User user, String message);
}
