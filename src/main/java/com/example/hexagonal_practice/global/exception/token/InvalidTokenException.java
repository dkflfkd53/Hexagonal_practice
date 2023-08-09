package com.example.hexagonal_practice.global.exception.token;

import com.example.hexagonal_practice.global.error.exception.BusinessException;
import com.example.hexagonal_practice.global.error.exception.ErrorCode;

public class InvalidTokenException extends BusinessException {

    public static final BusinessException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException(){
        super(ErrorCode.INVALID_TOKEN);
    }

}
