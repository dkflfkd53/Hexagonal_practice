package com.example.hexagonal_practice.account.application.service.pot;

import com.example.hexagonal_practice.account.application.port.in.pot.CancelPotUseCase;
import com.example.hexagonal_practice.account.application.port.in.user.UserFacadeUseCase;
import com.example.hexagonal_practice.account.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.account.domain.Board;
import com.example.hexagonal_practice.account.domain.User;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class CancelPotService implements CancelPotUseCase {
    private final UserFacadeUseCase userFacade;
    private final BoardRepositoryPort boardRepositoryPort;

    public void cancelPot(Long boardId) {
        User member = userFacade.currentUser();
        Board board = boardRepositoryPort.findBoardById(boardId);

        board.cancelMember(member);
    }
}
