package com.example.hexagonal_practice.account.application.port.in;

import com.example.hexagonal_practice.account.adapter.dto.request.BoardRequest;

public interface WriteBoardUseCase {
    void writeBoard(BoardRequest request);
}
