package com.example.hexagonal_practice.global.exception.user;

import com.example.hexagonal_practice.global.error.exception.BusinessException;
import com.example.hexagonal_practice.global.error.exception.ErrorCode;

public class UserNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}
