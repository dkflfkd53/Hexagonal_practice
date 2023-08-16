package com.example.hexagonal_practice.account.adapter.dto.response;

import com.example.hexagonal_practice.account.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponse {
    private Long id;

    private String username;

    public MemberResponse(User member) {
        id = member.getId();
        username = member.getUsername();
    }
}

