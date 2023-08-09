package com.example.hexagonal_practice.account.application.service.board;

import com.example.hexagonal_practice.account.application.port.in.board.DeleteBoardUseCase;
import com.example.hexagonal_practice.account.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class DeleteBoardService implements DeleteBoardUseCase {

    private final BoardRepositoryPort boardRepositoryPort;

    public void deleteBoard(Long boardId) {
        boardRepositoryPort.deleteBoardById(boardId);
    }

}
