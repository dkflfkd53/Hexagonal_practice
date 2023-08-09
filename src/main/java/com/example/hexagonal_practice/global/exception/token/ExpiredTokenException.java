package com.example.hexagonal_practice.global.exception.token;

import com.example.hexagonal_practice.global.error.exception.BusinessException;
import com.example.hexagonal_practice.global.error.exception.ErrorCode;

public class ExpiredTokenException extends BusinessException {

    public static final BusinessException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException(){
        super(ErrorCode.EXPIRED_TOKEN);
    }

}