package com.example.hexagonal_practice.account.adapter.in.web;

import com.example.hexagonal_practice.account.application.port.in.member.JoinPotUseCase;
import com.example.hexagonal_practice.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final JoinPotUseCase joinPotUseCase;

    @PostMapping("/member")
    public void joinPot() {
        joinPotUseCase.joinPot();
    }
}
