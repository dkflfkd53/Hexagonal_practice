package com.example.hexagonal_practice.account.application.port.in.user;

import org.springframework.http.ResponseEntity;

public interface OauthLoginUseCase {
    ResponseEntity<String> getGoogleAccessToken(String accessCode);
}
