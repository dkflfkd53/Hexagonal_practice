package com.example.hexagonal_practice.global.exception.board;

import com.example.hexagonal_practice.global.error.exception.BusinessException;
import com.example.hexagonal_practice.global.error.exception.ErrorCode;

public class BoardNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new BoardNotFoundException();

    public BoardNotFoundException() {
        super(ErrorCode.BOARD_NOT_FOUND);
    }

}
