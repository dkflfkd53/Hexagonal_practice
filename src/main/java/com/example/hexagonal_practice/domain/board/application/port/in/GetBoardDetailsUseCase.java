package com.example.hexagonal_practice.domain.board.account.application.port.in;

import com.example.hexagonal_practice.domain.board.account.adapter.dto.response.BoardResponse;

public interface GetBoardDetailsUseCase {
    BoardResponse getBoardDetails(Long boardId);
}
