package com.example.hexagonal_practice.account.application.service.user;

import com.example.hexagonal_practice.account.adapter.dto.response.TokenResponse;
import com.example.hexagonal_practice.account.application.port.in.user.TokenRefreshUseCase;
import com.example.hexagonal_practice.common.UseCase;
import com.example.hexagonal_practice.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class TokenRefreshService implements TokenRefreshUseCase {
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse tokenRefresh(String token) {
        return jwtTokenProvider.tokenRefresh(token);
    }
}
