package com.example.hexagonal_practice.global.exception.user;

import com.example.hexagonal_practice.global.error.exception.BusinessException;
import com.example.hexagonal_practice.global.error.exception.ErrorCode;

public class MemberCrowdedException extends BusinessException {

    public static final BusinessException EXCEPTION = new MemberCrowdedException();

    public MemberCrowdedException() {
        super(ErrorCode.MEMBER_CROWDED);
    }
}
