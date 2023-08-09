package com.example.hexagonal_practice.domain.board.application.port.in;

import com.example.hexagonal_practice.domain.board.adapter.dto.request.BoardRequest;

public interface ModifyBoardUseCase {
    void modifyBoard(Long boardId, BoardRequest request);
}
