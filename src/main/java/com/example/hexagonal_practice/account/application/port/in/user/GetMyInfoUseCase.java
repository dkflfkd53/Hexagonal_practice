package com.example.hexagonal_practice.account.application.port.in.user;

import com.example.hexagonal_practice.account.adapter.dto.response.UserResponse;

public interface GetMyInfoUseCase {
    UserResponse getMyInfo();
}
