package com.example.hexagonal_practice.domain.board.application.port.in;

import com.example.hexagonal_practice.domain.board.adapter.dto.request.BoardRequest;

public interface WriteBoardUseCase {
    void writeBoard(BoardRequest request);
}
