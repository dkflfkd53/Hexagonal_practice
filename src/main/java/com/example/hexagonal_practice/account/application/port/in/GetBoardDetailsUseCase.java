package com.example.hexagonal_practice.account.application.port.in;

import com.example.hexagonal_practice.account.adapter.dto.response.BoardResponse;

public interface GetBoardDetailsUseCase {
    BoardResponse getBoardDetails(Long boardId);
}
