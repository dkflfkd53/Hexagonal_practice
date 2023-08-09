package com.example.hexagonal_practice.account.application.port.in.user;

import com.example.hexagonal_practice.account.adapter.dto.request.UserRequest;

public interface SignUpUseCase {
    void signUp(UserRequest request);
}
