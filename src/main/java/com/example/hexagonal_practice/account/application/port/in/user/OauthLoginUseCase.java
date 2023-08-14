package com.example.hexagonal_practice.account.application.port.in.user;

public interface OauthLoginUseCase {
    void oauthLogin(String code, String registrationId);
}
