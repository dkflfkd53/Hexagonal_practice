package com.example.hexagonal_practice.global.exception.user;

import com.example.hexagonal_practice.global.error.exception.BusinessException;
import com.example.hexagonal_practice.global.error.exception.ErrorCode;

public class UserExistException extends BusinessException {

    public static final BusinessException EXCEPTION = new UserExistException();

    public UserExistException() {
        super(ErrorCode.USER_EXIST);
    }
}
