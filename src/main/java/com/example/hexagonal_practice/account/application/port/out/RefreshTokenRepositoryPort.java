package com.example.hexagonal_practice.account.application.port.out;

import com.example.hexagonal_practice.account.domain.RefreshToken;

public interface RefreshTokenRepositoryPort {
    void saveRefreshToken(RefreshToken refreshToken);

    RefreshToken findByToken(String token);

    void deleteToken(RefreshToken token);
}
