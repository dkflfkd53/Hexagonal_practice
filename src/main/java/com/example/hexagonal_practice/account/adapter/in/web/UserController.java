package com.example.hexagonal_practice.account.adapter.in.web;

import com.example.hexagonal_practice.account.adapter.dto.request.UserRequest;
import com.example.hexagonal_practice.account.adapter.dto.response.TokenResponse;
import com.example.hexagonal_practice.account.application.port.in.user.LoginUseCase;
import com.example.hexagonal_practice.account.application.port.in.user.SignUpUseCase;
import com.example.hexagonal_practice.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class UserController {

    private final SignUpUseCase signUpUseCase;
    private final LoginUseCase loginUseCase;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserRequest request) {
        signUpUseCase.signUp(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserRequest request) {
        return loginUseCase.login(request);
    }



}
