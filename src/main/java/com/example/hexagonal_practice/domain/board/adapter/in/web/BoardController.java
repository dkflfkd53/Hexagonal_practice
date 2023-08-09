package com.example.hexagonal_practice.domain.board.adapter.in.web;

import com.example.hexagonal_practice.common.WebAdapter;
import com.example.hexagonal_practice.domain.board.adapter.dto.request.BoardRequest;
import com.example.hexagonal_practice.domain.board.adapter.dto.response.BoardResponse;
import com.example.hexagonal_practice.domain.board.application.port.in.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final WriteBoardUseCase writeBoardUseCase;
    private final GetBoardDetailsUseCase getBoardDetailsUseCase;
    private final GetBoardListUseCase getBoardListUseCase;
    private final ModifyBoardUseCase modifyBoardUseCase;
    private final DeleteBoardUseCase deleteBoardUseCase;

    @PostMapping("/board")
    public void writeBoard(@RequestBody @Valid BoardRequest request) {
        writeBoardUseCase.writeBoard(request);
    }

    @GetMapping("/board/{boardId}")
    public BoardResponse getBoardDetails(@PathVariable Long boardId) {
        return getBoardDetailsUseCase.getBoardDetails(boardId);
    }

    @GetMapping("/board/list")
    public List<BoardResponse> getBoardList() {
        return getBoardListUseCase.getBoardList();
    }

    @PatchMapping("/board/{boardId}")
    public void modifyBoard(@PathVariable Long boardId, @RequestBody @Valid BoardRequest request) {
        modifyBoardUseCase.modifyBoard(boardId, request);
    }

    @DeleteMapping("/board/{boardId}")
    public void deleteBoard(@PathVariable Long boardId) {
        deleteBoardUseCase.deleteBoard(boardId);
    }

}
