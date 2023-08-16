package com.example.hexagonal_practice.account.application.port.in.pot;

import com.example.hexagonal_practice.account.domain.User;

import java.util.List;

public interface GetMemberUseCase {
    List<User> getMember(Long boardId);
}
