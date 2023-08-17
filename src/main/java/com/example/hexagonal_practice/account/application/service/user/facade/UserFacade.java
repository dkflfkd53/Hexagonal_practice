package com.example.hexagonal_practice.account.application.service.user.facade;

import com.example.hexagonal_practice.account.application.port.in.user.UserFacadeUseCase;
import com.example.hexagonal_practice.account.application.port.out.UserRepositoryPort;
import com.example.hexagonal_practice.account.domain.User;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

@UseCase
@RequiredArgsConstructor
public class UserFacade implements UserFacadeUseCase {
    private final UserRepositoryPort userRepositoryPort;

    public User currentUser() {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepositoryPort.findUserByUserId(userId);
    }
}
