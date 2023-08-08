package com.example.hexagonal_practice.account.application.port.in;

import com.example.hexagonal_practice.account.adapter.dto.request.BoardRequest;

public interface ModifyBoardUseCase {
    void modifyBoard(Long boardId, BoardRequest request);
}
