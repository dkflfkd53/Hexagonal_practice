package com.example.hexagonal_practice.domain.board.application.port.out;

import com.example.hexagonal_practice.domain.board.adapter.dto.request.BoardRequest;
import com.example.hexagonal_practice.domain.board.adapter.dto.response.BoardResponse;
import com.example.hexagonal_practice.domain.board.domain.Board;

import java.util.List;

public interface BoardRepositoryPort {

    Board save(BoardRequest request);

    Board findBoardById(Long boardId);

    void deleteBoardById(Long boardId);

    List<BoardResponse> findAllBoard();

}
