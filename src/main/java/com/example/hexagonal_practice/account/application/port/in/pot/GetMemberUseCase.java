package com.example.hexagonal_practice.account.application.port.in.pot;

import com.example.hexagonal_practice.account.adapter.dto.response.MemberResponse;

import java.util.List;

public interface GetMemberUseCase {
    List<MemberResponse> getMember(Long boardId);
}
