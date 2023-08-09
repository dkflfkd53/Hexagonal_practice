package com.example.hexagonal_practice.account.application.port.in.board;

import com.example.hexagonal_practice.account.adapter.dto.request.BoardRequest;

public interface WriteBoardUseCase {
    void writeBoard(BoardRequest request);
}
