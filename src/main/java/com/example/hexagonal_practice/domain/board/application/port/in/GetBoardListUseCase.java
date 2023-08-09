package com.example.hexagonal_practice.domain.board.account.application.port.in;

import com.example.hexagonal_practice.domain.board.account.adapter.dto.response.BoardResponse;

import java.util.List;

public interface GetBoardListUseCase {
    List<BoardResponse> getBoardList();
}
