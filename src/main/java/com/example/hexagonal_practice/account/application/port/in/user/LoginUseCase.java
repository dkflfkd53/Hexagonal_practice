package com.example.hexagonal_practice.account.application.port.in.user;

import com.example.hexagonal_practice.account.adapter.dto.request.UserRequest;
import com.example.hexagonal_practice.account.adapter.dto.response.TokenResponse;

public interface LoginUseCase {
    TokenResponse login(UserRequest request);
}
