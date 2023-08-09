package com.example.hexagonal_practice.domain.board.adapter.out.persistence;

import com.example.hexagonal_practice.domain.board.adapter.dto.request.BoardRequest;
import com.example.hexagonal_practice.domain.board.adapter.dto.response.BoardResponse;
import com.example.hexagonal_practice.domain.board.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.domain.board.domain.Board;
import com.example.hexagonal_practice.common.PersistenceAdapter;
import com.example.hexagonal_practice.global.exception.board.BoardNotFoundException;
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
                .orElseThrow(()-> BoardNotFoundException.EXCEPTION);
    }

    public List<BoardResponse> findAllBoard() {
        return boardRepository.findAll()
                .stream()
                .map(BoardResponse::new)
                .collect(Collectors.toList());
    }

    public void deleteBoardById(Long boardId) {
        Board board = boardRepository.findById(boardId)
                        .orElseThrow(()->BoardNotFoundException.EXCEPTION);

        boardRepository.delete(board);
    }

}
