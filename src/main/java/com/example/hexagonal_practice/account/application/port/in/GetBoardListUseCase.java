package com.example.hexagonal_practice.account.application.port.in;

import com.example.hexagonal_practice.account.adapter.dto.response.BoardResponse;

import java.util.List;

public interface GetBoardListUseCase {
    List<BoardResponse> getBoardList();
}
