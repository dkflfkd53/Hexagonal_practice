package com.example.hexagonal_practice.account.adapter.in.web;

import com.example.hexagonal_practice.account.adapter.dto.request.LoginRequest;
import com.example.hexagonal_practice.account.adapter.dto.request.RefreshRequest;
import com.example.hexagonal_practice.account.adapter.dto.request.SignUpRequest;
import com.example.hexagonal_practice.account.adapter.dto.response.TokenResponse;
import com.example.hexagonal_practice.account.adapter.dto.response.UserResponse;
import com.example.hexagonal_practice.account.application.port.in.user.*;
import com.example.hexagonal_practice.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class UserController {

    private final SignUpUseCase signUpUseCase;
    private final LoginUseCase loginUseCase;
    private final GetMyInfoUseCase getMyInfoUseCase;
    private final TokenRefreshUseCase tokenRefreshUseCase;
    private final OauthLoginUseCase oauthLoginUseCase;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid SignUpRequest request) {
        signUpUseCase.signUp(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginUseCase.login(request);
    }

    @PostMapping("/refresh")
    public TokenResponse tokenRefresh(@RequestBody RefreshRequest request) {
        return tokenRefreshUseCase.tokenRefresh(request.getRefreshToken());
    }

    @GetMapping("/user")
    public UserResponse getMyInfo() {
        return getMyInfoUseCase.getMyInfo();
    }

    @RequestMapping(value = "/login/oauth2", produces = "application/json")
    @GetMapping("/code/{registrationId}")
    public void googleLogin(@RequestParam String code, @PathVariable String registrationId) {
        oauthLoginUseCase.oauthLogin(code, registrationId);
    }

}
