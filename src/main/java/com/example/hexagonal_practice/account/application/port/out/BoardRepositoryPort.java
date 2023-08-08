package com.example.hexagonal_practice.account.application.port.out;

import com.example.hexagonal_practice.account.adapter.dto.request.BoardRequest;
import com.example.hexagonal_practice.account.domain.Board;

public interface BoardRepositoryPort {

    Board save(BoardRequest request);

    Board findBoardById(Long boardId);

    void deleteBoardById(Long boardId);

}
