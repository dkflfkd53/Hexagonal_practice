package com.example.hexagonal_practice.account.application.service.member;

import com.example.hexagonal_practice.account.adapter.out.persistence.member.MemberRepository;
import com.example.hexagonal_practice.account.application.port.in.member.JoinPotUseCase;
import com.example.hexagonal_practice.account.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.account.application.port.out.MemberRepositoryPort;
import com.example.hexagonal_practice.account.application.port.out.UserRepositoryPort;
import com.example.hexagonal_practice.account.application.service.user.facade.UserFacade;
import com.example.hexagonal_practice.account.domain.Board;
import com.example.hexagonal_practice.account.domain.Member;
import com.example.hexagonal_practice.account.domain.User;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class JoinPotService implements JoinPotUseCase {

    private final MemberRepositoryPort memberRepositoryPort;
    private final BoardRepositoryPort boardRepositoryPort;
    private final UserFacade userFacade;

    public void joinPot() {
        User user = userFacade.currentUser();
        Board board = boardRepositoryPort.findBoardById(user.getId());

        Member member = Member.builder()
                .id(user.getId())
                .board(board)
                .username(user.getUsername())
                .build();
        board.joinMember();
        memberRepositoryPort.saveMember(member);
    }

}
