package com.example.hexagonal_practice.account.application.service.user;

import com.example.hexagonal_practice.account.adapter.dto.request.UserRequest;
import com.example.hexagonal_practice.account.application.port.in.user.SignUpUseCase;
import com.example.hexagonal_practice.account.application.port.out.UserRepositoryPort;
import com.example.hexagonal_practice.account.domain.User;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class SignUpService implements SignUpUseCase {
    private final UserRepositoryPort userRepositoryPort;

    public void signUp(UserRequest request) {
        User user = User.builder()
                .userId(request.getUserId())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        userRepositoryPort.saveUser(user);
    }
}
