package com.example.hexagonal_practice.account.application.service.pot;

import com.example.hexagonal_practice.account.application.port.in.pot.JoinPotUseCase;
import com.example.hexagonal_practice.account.application.port.in.user.UserFacadeUseCase;
import com.example.hexagonal_practice.account.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.account.application.service.user.facade.UserFacade;
import com.example.hexagonal_practice.account.domain.Board;
import com.example.hexagonal_practice.account.domain.User;
import com.example.hexagonal_practice.common.UseCase;
import com.example.hexagonal_practice.global.exception.user.MemberCrowdedException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class JoinPotService implements JoinPotUseCase {
    private final BoardRepositoryPort boardRepositoryPort;
    private final UserFacadeUseCase userFacade;

    public void joinPot(Long boardId) {
        User user = userFacade.currentUser();
        Board board = boardRepositoryPort.findBoardById(boardId);

        if(board.getMemberNumber() == board.getMembers().size())throw MemberCrowdedException.EXCEPTION;

        board.joinMember(user);
    }
}
