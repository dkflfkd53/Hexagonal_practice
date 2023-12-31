package com.example.hexagonal_practice.account.adapter.dto.response;

import com.example.hexagonal_practice.account.domain.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardResponse {
    private String title;

    private String content;

    private Long memberNumber;

    public BoardResponse(Board board) {
        title = board.getTitle();
        content = board.getContent();
        memberNumber = board.getMemberNumber();
    }
}
