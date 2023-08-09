package com.example.hexagonal_practice.account.application.port.out;

import com.example.hexagonal_practice.account.domain.Board;
import com.example.hexagonal_practice.account.adapter.dto.request.BoardRequest;
import com.example.hexagonal_practice.account.adapter.dto.response.BoardResponse;

import java.util.List;

public interface BoardRepositoryPort {

    Board save(BoardRequest request);

    Board findBoardById(Long boardId);

    void deleteBoardById(Long boardId);

    List<BoardResponse> findAllBoard();

}
