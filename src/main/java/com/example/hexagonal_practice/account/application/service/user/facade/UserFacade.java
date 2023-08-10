package com.example.hexagonal_practice.account.application.service.user.facade;

import com.example.hexagonal_practice.account.application.port.out.UserRepositoryPort;
import com.example.hexagonal_practice.account.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepositoryPort userRepositoryPort;

    public User currentUser() {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepositoryPort.findUserByUserId(userId);
    }
}
