package com.example.hexagonal_practice.account.application.port.in.user;

import com.example.hexagonal_practice.account.adapter.dto.request.SignUpRequest;

public interface SignUpUseCase {
    void signUp(SignUpRequest request);
}
