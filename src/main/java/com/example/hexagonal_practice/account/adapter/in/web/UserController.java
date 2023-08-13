package com.example.hexagonal_practice.account.adapter.in.web;

import com.example.hexagonal_practice.account.adapter.dto.request.UserRequest;
import com.example.hexagonal_practice.account.adapter.dto.response.TokenResponse;
import com.example.hexagonal_practice.account.adapter.dto.response.UserResponse;
import com.example.hexagonal_practice.account.application.port.in.user.GetMyInfoUseCase;
import com.example.hexagonal_practice.account.application.port.in.user.LoginUseCase;
import com.example.hexagonal_practice.account.application.port.in.user.OauthLoginUseCase;
import com.example.hexagonal_practice.account.application.port.in.user.SignUpUseCase;
import com.example.hexagonal_practice.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/login/oauth2", produces = "application/json")
public class UserController {

    private final SignUpUseCase signUpUseCase;
    private final LoginUseCase loginUseCase;
    private final GetMyInfoUseCase getMyInfoUseCase;
    private final OauthLoginUseCase oauthLoginUseCase;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserRequest request) {
        signUpUseCase.signUp(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserRequest request) {
        return loginUseCase.login(request);
    }

    @GetMapping("/user")
    public UserResponse getMyInfo() {
        return getMyInfoUseCase.getMyInfo();
    }

    @PostMapping("/code")
    public ResponseEntity<String> oauthLogin(@RequestParam("code") String accessCode) {
        return oauthLoginUseCase.getGoogleAccessToken(accessCode);
    }

}
