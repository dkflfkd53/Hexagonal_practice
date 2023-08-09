package com.example.hexagonal_practice.account.application.service;

import com.example.hexagonal_practice.account.adapter.dto.request.BoardRequest;
import com.example.hexagonal_practice.account.application.port.in.WriteBoardUseCase;
import com.example.hexagonal_practice.account.application.port.out.BoardRepositoryPort;
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
