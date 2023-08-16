package com.example.hexagonal_practice.account.application.service.member;

import com.example.hexagonal_practice.account.application.port.in.member.GetMemberUseCase;
import com.example.hexagonal_practice.account.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.account.domain.Board;
import com.example.hexagonal_practice.account.domain.Member;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@UseCase
@Transactional
public class GetMemberService implements GetMemberUseCase {
    private final BoardRepositoryPort boardRepositoryPort;

    public List<Member> getMember(Long boardId) {
        Board board = boardRepositoryPort.findBoardById(boardId);

        return board.getMembers();
    }
}
