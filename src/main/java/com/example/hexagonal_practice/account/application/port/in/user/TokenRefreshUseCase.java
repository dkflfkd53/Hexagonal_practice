package com.example.hexagonal_practice.account.application.port.in.user;

import com.example.hexagonal_practice.account.adapter.dto.response.TokenResponse;

public interface TokenRefreshUseCase {
    TokenResponse tokenRefresh(String token);
}
