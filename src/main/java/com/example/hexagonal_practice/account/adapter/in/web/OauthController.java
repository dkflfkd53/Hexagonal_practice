package com.example.hexagonal_practice.account.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/accounts")
public class OauthController {
    private final OauthService oauthService;

    // 로그인 인증을 할 수 있도록 리디렉션 해주는 핸들러
    @GetMapping("/auth/{type}")
    public void socialLoginRequest(@PathVariable("type")String type, HttpServletResponse response) throws IOException {
        String requestURL = oauthService.request(type.toUpperCase());
        response.sendRedirect(requestURL);
    }
}