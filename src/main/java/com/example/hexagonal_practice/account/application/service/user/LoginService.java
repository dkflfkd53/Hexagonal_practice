package com.example.hexagonal_practice.account.application.service.user;

import com.example.hexagonal_practice.account.adapter.dto.request.UserRequest;
import com.example.hexagonal_practice.account.adapter.dto.response.TokenResponse;
import com.example.hexagonal_practice.account.application.port.in.user.LoginUseCase;
import com.example.hexagonal_practice.account.application.port.out.UserRepositoryPort;
import com.example.hexagonal_practice.account.domain.User;
import com.example.hexagonal_practice.common.UseCase;
import com.example.hexagonal_practice.global.exception.user.PasswordMismatchException;
import com.example.hexagonal_practice.global.security.jwt.JwtProperties;
import com.example.hexagonal_practice.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RequiredArgsConstructor
@UseCase
@Transactional
public class LoginService implements LoginUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    public TokenResponse login(UserRequest request) {

        Date now = new Date();

        User user = userRepositoryPort.findUserByUserId(request.getUserId());

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(user.getUserId()))
                .refreshToken(jwtTokenProvider.createRefreshToken(user.getUserId()))
                .accessExpiredAt(new Date(now.getTime() + jwtProperties.getAccessExpiration()))
                .refreshExpiredAt(new Date(now.getTime() + jwtProperties.getRefreshExpiration()))
                .build();

    }

}
