package com.example.hexagonal_practice.domain.board.application.service;

import com.example.hexagonal_practice.domain.board.adapter.dto.response.BoardResponse;
import com.example.hexagonal_practice.domain.board.application.port.in.GetBoardDetailsUseCase;
import com.example.hexagonal_practice.domain.board.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.domain.board.domain.Board;
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
