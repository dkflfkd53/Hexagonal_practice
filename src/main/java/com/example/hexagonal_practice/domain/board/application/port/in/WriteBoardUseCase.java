package com.example.hexagonal_practice.domain.board.account.application.port.in;

import com.example.hexagonal_practice.domain.board.account.adapter.dto.request.BoardRequest;

public interface WriteBoardUseCase {
    void writeBoard(BoardRequest request);
}
