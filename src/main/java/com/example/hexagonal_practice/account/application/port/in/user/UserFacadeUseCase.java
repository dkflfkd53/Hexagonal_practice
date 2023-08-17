package com.example.hexagonal_practice.account.application.port.in.user;

import com.example.hexagonal_practice.account.domain.User;

public interface UserFacadeUseCase {
    User currentUser();
}
