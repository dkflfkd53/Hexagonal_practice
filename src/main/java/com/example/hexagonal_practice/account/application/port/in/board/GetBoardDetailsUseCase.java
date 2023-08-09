package com.example.hexagonal_practice.account.application.port.in.board;

import com.example.hexagonal_practice.account.adapter.dto.response.BoardResponse;

public interface GetBoardDetailsUseCase {
    BoardResponse getBoardDetails(Long boardId);
}
