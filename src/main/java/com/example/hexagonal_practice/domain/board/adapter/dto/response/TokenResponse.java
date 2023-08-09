package com.example.hexagonal_practice.domain.board.adapter.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class TokenResponse {
    private String accessToken;

    private String refreshToken;

    private Date accessExpiredAt;

    private Date refreshExpiredAt;
}
