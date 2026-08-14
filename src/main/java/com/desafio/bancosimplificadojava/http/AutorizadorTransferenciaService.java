package com.desafio.bancosimplificadojava.http;

import com.desafio.bancosimplificadojava.interfaces.IAutorizadorTransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class AutorizadorTransferenciaService implements IAutorizadorTransferenciaService {
    @Autowired
    private RestTemplate restTemplate;

    private final static String authorizationUrl = "https://util.devi.tools/api/v2/authorize";

    @Override
    public boolean Authorize(){
        var authorizationResponse = restTemplate.getForEntity(authorizationUrl, Map.class);
        if (authorizationResponse.getStatusCode() ==  HttpStatus.OK) {
            assert authorizationResponse.getBody() != null;
            String status = (String) authorizationResponse.getBody().get("status");
            return "Success".equalsIgnoreCase(status);
        } else return false;
    }
}
