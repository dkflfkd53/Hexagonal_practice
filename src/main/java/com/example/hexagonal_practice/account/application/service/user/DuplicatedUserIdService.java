package com.example.hexagonal_practice.account.application.service.user;

import com.example.hexagonal_practice.account.application.port.in.user.DuplicatedUserIdUseCase;
import com.example.hexagonal_practice.account.application.port.out.UserRepositoryPort;
import com.example.hexagonal_practice.common.UseCase;
import com.example.hexagonal_practice.global.exception.user.UserExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class DuplicatedUserIdService implements DuplicatedUserIdUseCase {
    private final UserRepositoryPort userRepositoryPort;

    public void duplicatedUserId(String userId) {
        if (userRepositoryPort.exist(userId)) {
            throw UserExistException.EXCEPTION;
        }
    }
}
