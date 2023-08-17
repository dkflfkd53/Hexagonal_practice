package com.example.hexagonal_practice.account.adapter.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RefreshRequest {

    private String refreshToken;
}