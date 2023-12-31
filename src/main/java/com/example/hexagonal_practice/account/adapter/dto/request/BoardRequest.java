package com.example.hexagonal_practice.account.adapter.dto.request;

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

    @NotNull
    private Long memberNumber;
}
