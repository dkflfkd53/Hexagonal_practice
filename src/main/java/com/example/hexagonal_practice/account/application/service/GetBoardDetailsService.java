package com.example.hexagonal_practice.account.application.service;

import com.example.hexagonal_practice.account.adapter.dto.response.BoardResponse;
import com.example.hexagonal_practice.account.application.port.in.GetBoardDetailsUseCase;
import com.example.hexagonal_practice.account.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.account.domain.Board;
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
