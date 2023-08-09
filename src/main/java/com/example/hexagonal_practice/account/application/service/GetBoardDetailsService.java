package com.example.hexagonal_practice.domain.account.application.service;

import com.example.hexagonal_practice.domain.account.adapter.dto.response.BoardResponse;
import com.example.hexagonal_practice.domain.account.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.domain.account.domain.Board;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class GetBoardDetailsService implements GetBoardDetailsUseCase {

    private final BoardRepositoryPort boardRepositoryPort;

    public BoardResponse getBoardDetails(Long boardId) {
        Board board = boardRepositoryPort.findBoardById(boardId);

        return new BoardResponse(board);
    }
}
