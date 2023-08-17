package com.example.hexagonal_practice.account.adapter.in.web;

import com.example.hexagonal_practice.account.adapter.dto.response.MemberResponse;
import com.example.hexagonal_practice.account.application.port.in.pot.CancelPotUseCase;
import com.example.hexagonal_practice.account.application.port.in.pot.GetMemberUseCase;
import com.example.hexagonal_practice.account.application.port.in.pot.JoinPotUseCase;
import com.example.hexagonal_practice.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class PotController {

    private final JoinPotUseCase joinPotUseCase;
    private final GetMemberUseCase getMemberUseCase;
    private final CancelPotUseCase cancelPotUseCase;

    @PostMapping("/pot/{boardId}")
    public void joinPot(@PathVariable Long boardId) {
        joinPotUseCase.joinPot(boardId);
    }

    @GetMapping("/pot/{boardId}")
    public List<MemberResponse> getMember(@PathVariable Long boardId) {
        return getMemberUseCase.getMember(boardId);
    }

    @DeleteMapping("/pot/{boardId}")
    public void cancelPot(@PathVariable Long boardId) {
        cancelPotUseCase.cancelPot(boardId);
    }

}
