package com.example.hexagonal_practice.account.application.service.board;

import com.example.hexagonal_practice.account.adapter.dto.request.BoardRequest;
import com.example.hexagonal_practice.account.application.port.in.board.WriteBoardUseCase;
import com.example.hexagonal_practice.account.application.port.in.user.UserFacadeUseCase;
import com.example.hexagonal_practice.account.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.account.domain.Board;
import com.example.hexagonal_practice.account.domain.User;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RequiredArgsConstructor
@UseCase
@Transactional
public class WriteBoardService implements WriteBoardUseCase {

    private final BoardRepositoryPort boardRepositoryPort;
    private final UserFacadeUseCase userFacade;

    public void writeBoard(BoardRequest request) {
        User user = userFacade.currentUser();

        Board board = Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .memberNumber(request.getMemberNumber())
                .members(new ArrayList<>())
                .user(user)
                .build();

        board.joinMember(user);
        boardRepositoryPort.saveBoard(board);
    }

}
