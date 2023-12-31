package com.example.hexagonal_practice.account.application.service.user;

import com.example.hexagonal_practice.account.adapter.dto.request.SignUpRequest;
import com.example.hexagonal_practice.account.application.port.in.user.DuplicatedUserIdUseCase;
import com.example.hexagonal_practice.account.application.port.in.user.SignUpUseCase;
import com.example.hexagonal_practice.account.application.port.out.UserRepositoryPort;
import com.example.hexagonal_practice.account.domain.User;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class SignUpService implements SignUpUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoder passwordEncoder;
    private final DuplicatedUserIdUseCase duplicatedUserIdUseCase;

    public void signUp(SignUpRequest request) {
        duplicatedUserIdUseCase.duplicatedUserId(request.getUserId());
        String password = passwordEncoder.encode(request.getPassword());

        User user = User.builder()
                .userId(request.getUserId())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(password)
                .build();

        userRepositoryPort.saveUser(user);
    }

}
