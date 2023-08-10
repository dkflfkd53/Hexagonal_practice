package com.example.hexagonal_practice.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // jwt
    EXPIRED_TOKEN(401 , "Expired token"),
    INVALID_TOKEN(401, "Invalid token"),
    REFRESH_TOKEN_NOT_FOUND(403,"RefreshToken not found"),

    //user
    USER_NOT_FOUND(404,"User not found"),
    PASSWORD_MISMATCH(404,"Password mismatch"),
    USER_EXIST(404,"User already exist"),

    //board
    BOARD_NOT_FOUND(404, "Board not found"),

    // general
    BAD_REQUEST(400, "Bad request"),
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private final int statusCode;
    private final String message;
}