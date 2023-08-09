package com.example.hexagonal_practice.domain.account.application.port.out;

import com.example.hexagonal_practice.domain.account.adapter.dto.request.BoardRequest;
import com.example.hexagonal_practice.domain.account.adapter.dto.response.BoardResponse;
import com.example.hexagonal_practice.domain.account.domain.Board;

import java.util.List;

public interface BoardRepositoryPort {

    Board save(BoardRequest request);

    Board findBoardById(Long boardId);

    void deleteBoardById(Long boardId);

    List<BoardResponse> findAllBoard();

}
