package com.example.hexagonal_practice.account.application.port.in.member;

import com.example.hexagonal_practice.account.domain.Member;

import java.util.List;

public interface GetMemberUseCase {
    List<Member> getMember(Long boardId);
}
