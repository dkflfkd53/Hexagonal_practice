package com.example.hexagonal_practice.account.application.port.out;

import com.example.hexagonal_practice.account.domain.Member;

public interface MemberRepositoryPort {
    void saveMember(Member member);
}
