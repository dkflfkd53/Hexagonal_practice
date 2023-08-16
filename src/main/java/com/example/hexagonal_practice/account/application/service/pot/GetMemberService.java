package com.example.hexagonal_practice.account.application.service.pot;

import com.example.hexagonal_practice.account.adapter.dto.response.MemberResponse;
import com.example.hexagonal_practice.account.application.port.in.pot.GetMemberUseCase;
import com.example.hexagonal_practice.account.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.account.domain.Board;
import com.example.hexagonal_practice.account.domain.User;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@UseCase
@Transactional
public class GetMemberService implements GetMemberUseCase {

    private final BoardRepositoryPort boardRepositoryPort;

    public List<MemberResponse> getMember(Long boardId) {
        Board board = boardRepositoryPort.findBoardById(boardId);

        return board.getMembers()
                .stream()
                .map(MemberResponse::new)
                .collect(Collectors.toList());
    }
}
