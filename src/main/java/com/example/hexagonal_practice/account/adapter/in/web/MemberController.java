package com.example.hexagonal_practice.account.adapter.in.web;

import com.example.hexagonal_practice.account.application.port.in.member.GetMemberUseCase;
import com.example.hexagonal_practice.account.application.port.in.member.JoinPotUseCase;
import com.example.hexagonal_practice.account.domain.Member;
import com.example.hexagonal_practice.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final JoinPotUseCase joinPotUseCase;
    private final GetMemberUseCase getMemberUseCase;

    @PostMapping("/member/{boardId}")
    public void joinPot(@PathVariable Long boardId) {
        joinPotUseCase.joinPot(boardId);
    }

    @GetMapping("/member/{boardId}")
    public List<Member> getMember(@PathVariable Long boardId) {
        return getMemberUseCase.getMember(boardId);
    }

}
