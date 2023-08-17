package com.example.hexagonal_practice.account.application.port.in.user;

import com.example.hexagonal_practice.account.adapter.dto.request.LoginRequest;
import com.example.hexagonal_practice.account.adapter.dto.response.TokenResponse;

public interface LoginUseCase {
    TokenResponse login(LoginRequest request);
}
