package com.example.hexagonal_practice.domain.board.application.port.in;

import com.example.hexagonal_practice.domain.board.adapter.dto.response.BoardResponse;

public interface GetBoardDetailsUseCase {
    BoardResponse getBoardDetails(Long boardId);
}
