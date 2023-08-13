package com.example.hexagonal_practice.account.application.service.user;

import com.example.hexagonal_practice.account.application.port.in.user.OauthLoginUseCase;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@UseCase
@Transactional
public class OauthLoginService implements OauthLoginUseCase {

    private final String GOOGLE_TOKEN_URL = "https://oauth2.googleapis.com/token";
    @Value("${CLIENT_ID}")
    private String GOOGLE_CLIENT_ID;
    @Value("${CLIENT_PASSWORD}")
    private String GOOGLE_CLIENT_SECRET;
    @Value("${REDIRECT_URL}")
    private String LOGIN_REDIRECT_URL;

    public ResponseEntity<String> getGoogleAccessToken(String accessCode) {

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();

        params.put("code", accessCode);
        params.put("client_id", GOOGLE_CLIENT_ID);
        params.put("client_secret", GOOGLE_CLIENT_SECRET);
        params.put("redirect_uri", LOGIN_REDIRECT_URL);
        params.put("grant_type", "authorization_code");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(GOOGLE_TOKEN_URL,params,String.class);

        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity;
        }
        return null;
    }
}
