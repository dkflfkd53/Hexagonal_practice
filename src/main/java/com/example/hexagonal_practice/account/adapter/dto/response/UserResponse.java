package com.example.hexagonal_practice.account.adapter.dto.response;

import com.example.hexagonal_practice.account.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponse {
    private String userId;

    private String username;

    public UserResponse(User user) {
        userId = user.getUserId();
        username = user.getUsername();
    }
}
