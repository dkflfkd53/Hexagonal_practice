package com.example.hexagonal_practice.account.adapter.out.persistence;

import com.example.hexagonal_practice.account.application.port.out.UserRepositoryPort;
import com.example.hexagonal_practice.account.domain.User;
import com.example.hexagonal_practice.common.PersistenceAdapter;
import com.example.hexagonal_practice.global.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class UserPersistenceAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findUserByUserId(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

    public boolean exist(String userId) {
        return userRepository.findByUserId(userId).isPresent();
    }

}
