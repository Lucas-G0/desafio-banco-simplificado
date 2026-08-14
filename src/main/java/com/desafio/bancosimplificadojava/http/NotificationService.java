package com.desafio.bancosimplificadojava.http;

import com.desafio.bancosimplificadojava.interfaces.INotificationService;
import com.desafio.bancosimplificadojava.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService implements INotificationService {
    @Autowired
    private RestTemplate restTemplate;

    private final static String notificationUrl = "https://util.devi.tools/api/v1/notify";
    @Override
    public void sendNotification(User user, String message) {
        var email = user.getEmail();
        // var notificationResponse = restTemplate.postForEntity(notificationUrl, email, String.class);
        // if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
        //    throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        // }
    }
}
