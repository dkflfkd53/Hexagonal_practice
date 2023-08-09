package com.example.hexagonal_practice.domain.board.adapter.dto.response;

import com.example.hexagonal_practice.domain.board.domain.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardResponse {

    private String title;

    private String content;

    public BoardResponse(Board board) {
        title = board.getTitle();
        content = board.getContent();
    }

}
