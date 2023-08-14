package com.example.hexagonal_practice.account.adapter.out.persistence.token;

import com.example.hexagonal_practice.account.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}