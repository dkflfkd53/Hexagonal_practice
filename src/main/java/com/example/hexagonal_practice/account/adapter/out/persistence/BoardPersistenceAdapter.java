package com.example.hexagonal_practice.account.adapter.out.persistence;

import com.example.hexagonal_practice.account.adapter.dto.request.BoardRequest;
import com.example.hexagonal_practice.account.adapter.dto.response.BoardResponse;
import com.example.hexagonal_practice.account.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.account.domain.Board;
import com.example.hexagonal_practice.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@PersistenceAdapter
public class BoardPersistenceAdapter implements BoardRepositoryPort {

    private final BoardRepository boardRepository;

    public Board save(BoardRequest request) {
        return boardRepository.save(
                Board.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build());
    }

    public Board findBoardById(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow();
    }

    public List<BoardResponse> findAllBoard() {
        return boardRepository.findAll()
                .stream()
                .map(BoardResponse::new)
                .collect(Collectors.toList());
    }

    public void deleteBoardById(Long boardId) {
        Board board = boardRepository.findById(boardId)
                        .orElseThrow();

        boardRepository.delete(board);
    }

}
