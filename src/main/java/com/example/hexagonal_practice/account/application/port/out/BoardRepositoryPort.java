package com.example.hexagonal_practice.account.application.port.out;

import com.example.hexagonal_practice.account.adapter.dto.response.BoardResponse;
import com.example.hexagonal_practice.account.domain.Board;

import java.util.List;

public interface BoardRepositoryPort {
    void saveBoard(Board board);

    Board findBoardById(Long boardId);

    void deleteBoardById(Long boardId);

    List<BoardResponse> findAllBoard();
}
