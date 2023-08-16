package com.example.hexagonal_practice.account.application.service.pot;

import com.example.hexagonal_practice.account.application.port.in.pot.JoinPotUseCase;
import com.example.hexagonal_practice.account.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.account.application.service.user.facade.UserFacade;
import com.example.hexagonal_practice.account.domain.Board;
import com.example.hexagonal_practice.account.domain.User;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class JoinPotService implements JoinPotUseCase {
    private final BoardRepositoryPort boardRepositoryPort;
    private final UserFacade userFacade;

    public void joinPot(Long boardId) {
        User user = userFacade.currentUser();
        Board board = boardRepositoryPort.findBoardById(boardId);

        User member = User.builder()
                .username(user.getUsername())
                .build();
        board.joinMember(member);
        board.addMember();
    }
}
