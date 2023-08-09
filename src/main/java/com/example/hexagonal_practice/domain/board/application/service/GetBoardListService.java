package com.example.hexagonal_practice.domain.board.application.service;

import com.example.hexagonal_practice.domain.board.adapter.dto.response.BoardResponse;
import com.example.hexagonal_practice.domain.board.application.port.in.GetBoardListUseCase;
import com.example.hexagonal_practice.domain.board.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@UseCase
@Transactional
public class GetBoardListService implements GetBoardListUseCase {

    private final BoardRepositoryPort boardRepositoryPort;

    public List<BoardResponse> getBoardList() {
        return boardRepositoryPort.findAllBoard();
    }

}