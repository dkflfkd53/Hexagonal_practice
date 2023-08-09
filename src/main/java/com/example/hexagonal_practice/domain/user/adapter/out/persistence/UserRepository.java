package com.example.hexagonal_practice.domain.user.adapter.out.persistence;

import com.example.hexagonal_practice.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
}
