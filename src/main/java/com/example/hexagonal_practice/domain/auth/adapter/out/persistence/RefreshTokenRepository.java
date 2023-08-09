package com.example.hexagonal_practice.domain.auth.adapter.out.persistence;

import com.example.hexagonal_practice.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findByToken(String token);
}