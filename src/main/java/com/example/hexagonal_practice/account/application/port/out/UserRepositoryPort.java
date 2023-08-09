package com.example.hexagonal_practice.account.application.port.out;

import com.example.hexagonal_practice.account.domain.User;

public interface UserRepositoryPort {

    void saveUser(User user);

    User findUserByUserId(String userId);

}
