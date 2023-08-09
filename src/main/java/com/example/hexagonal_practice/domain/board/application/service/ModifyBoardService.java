package com.example.hexagonal_practice.domain.board.application.service;

import com.example.hexagonal_practice.domain.board.adapter.dto.request.BoardRequest;
import com.example.hexagonal_practice.domain.board.application.port.in.ModifyBoardUseCase;
import com.example.hexagonal_practice.domain.board.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.domain.board.domain.Board;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class ModifyBoardService implements ModifyBoardUseCase {

    private final BoardRepositoryPort boardRepositoryPort;

    public void modifyBoard(Long boardId, BoardRequest request) {
        Board board = boardRepositoryPort.findBoardById(boardId);

        board.modifyBoard(request.getTitle(), request.getContent());
    }
}