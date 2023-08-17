package com.example.hexagonal_practice.global.exception.board;

import com.example.hexagonal_practice.global.error.exception.BusinessException;
import com.example.hexagonal_practice.global.error.exception.ErrorCode;

public class NotWriterException extends BusinessException {

    public static final BusinessException EXCEPTION = new NotWriterException();

    public NotWriterException() {
        super(ErrorCode.NOT_WRITER);
    }

}
