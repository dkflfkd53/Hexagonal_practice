package com.example.hexagonal_practice.account.adapter.in.web;

import com.example.hexagonal_practice.account.adapter.dto.request.BoardRequest;
import com.example.hexagonal_practice.account.adapter.dto.response.BoardResponse;
import com.example.hexagonal_practice.account.application.port.in.DeleteBoardUseCase;
import com.example.hexagonal_practice.account.application.port.in.GetBoardDetailsUseCase;
import com.example.hexagonal_practice.account.application.port.in.ModifyBoardUseCase;
import com.example.hexagonal_practice.account.application.port.in.WriteBoardUseCase;
import com.example.hexagonal_practice.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final WriteBoardUseCase writeBoardUseCase;

    private final GetBoardDetailsUseCase getBoardDetailsUseCase;

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

    @PatchMapping("/board/{boardId}")
    public void modifyBoard(@PathVariable Long boardId, @RequestBody @Valid BoardRequest request) {
        modifyBoardUseCase.modifyBoard(boardId, request);
    }

    @DeleteMapping("/board/{boardId}")
    public void deleteBoard(@PathVariable Long boardId) {
        deleteBoardUseCase.deleteBoard(boardId);
    }

}
