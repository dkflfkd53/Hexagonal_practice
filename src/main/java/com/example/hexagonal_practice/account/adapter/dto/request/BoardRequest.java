package com.example.hexagonal_practice.domain.account.adapter.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardRequest {

    @NotNull
    private String title;

    @NotNull
    private String content;

}
