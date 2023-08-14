package com.example.hexagonal_practice.global.security.auth;

import com.example.hexagonal_practice.account.adapter.out.persistence.user.UserRepository;
import com.example.hexagonal_practice.account.domain.User;
import com.example.hexagonal_practice.global.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) {

        User user = userRepository.findByUserId(userId)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        return new CustomUserDetails(user);
    }

}
