package com.example.hexagonal_practice.domain.board.application.service;

import com.example.hexagonal_practice.domain.board.adapter.dto.request.BoardRequest;
import com.example.hexagonal_practice.domain.board.application.port.in.WriteBoardUseCase;
import com.example.hexagonal_practice.domain.board.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class WriteBoardService implements WriteBoardUseCase {

    private final BoardRepositoryPort boardRepositoryPort;

    public void writeBoard(BoardRequest request) {
        boardRepositoryPort.save(request);
    }

}
