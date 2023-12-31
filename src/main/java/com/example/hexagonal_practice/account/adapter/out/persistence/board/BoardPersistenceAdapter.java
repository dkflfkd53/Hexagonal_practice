package com.example.hexagonal_practice.account.adapter.out.persistence.board;

import com.example.hexagonal_practice.account.adapter.dto.response.BoardResponse;
import com.example.hexagonal_practice.account.application.port.out.BoardRepositoryPort;
import com.example.hexagonal_practice.account.domain.Board;
import com.example.hexagonal_practice.common.PersistenceAdapter;
import com.example.hexagonal_practice.global.exception.board.BoardNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@PersistenceAdapter
public class BoardPersistenceAdapter implements BoardRepositoryPort {

    private final BoardRepository boardRepository;

    public void saveBoard(Board board) {
        boardRepository.save(board);
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
                        .orElseThrow(()-> BoardNotFoundException.EXCEPTION);

        boardRepository.delete(board);
    }

}
