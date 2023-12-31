package com.example.hexagonal_practice.account.adapter.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequest {
    @NotNull
    private String userId;

    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;
}
