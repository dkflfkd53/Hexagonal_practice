package com.example.hexagonal_practice.account.adapter.out.persistence.token;

import com.example.hexagonal_practice.account.application.port.out.RefreshTokenRepositoryPort;
import com.example.hexagonal_practice.account.domain.RefreshToken;
import com.example.hexagonal_practice.common.PersistenceAdapter;
import com.example.hexagonal_practice.global.exception.token.InvalidTokenException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class RefreshTokenPersistenceAdapter implements RefreshTokenRepositoryPort {

    private final RefreshTokenRepository refreshTokenRepository;

    public void saveRefreshToken(RefreshToken refreshToken) {
        refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken findByToken(String token) {
        return refreshTokenRepository.findByToken(token)
                .orElseThrow(()-> InvalidTokenException.EXCEPTION);
    }

    public void deleteToken(RefreshToken token) {
        refreshTokenRepository.delete(token);
    }

}
