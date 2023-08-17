package com.example.hexagonal_practice.account.application.service.board;

import com.example.hexagonal_practice.account.application.port.in.board.DeleteBoardUseCase;
import com.example.hexagonal_practice.account.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.account.application.service.user.facade.UserFacade;
import com.example.hexagonal_practice.account.domain.Board;
import com.example.hexagonal_practice.account.domain.User;
import com.example.hexagonal_practice.common.UseCase;
import com.example.hexagonal_practice.global.exception.board.NotWriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class DeleteBoardService implements DeleteBoardUseCase {

    private final BoardRepositoryPort boardRepositoryPort;
    private final UserFacade userFacade;

    public void deleteBoard(Long boardId) {
        User user = userFacade.currentUser();
        Board board = boardRepositoryPort.findBoardById(boardId);

        if(!(board.getUser().equals(user.getUserId())))throw NotWriterException.EXCEPTION;

        boardRepositoryPort.deleteBoardById(boardId);
    }

}
