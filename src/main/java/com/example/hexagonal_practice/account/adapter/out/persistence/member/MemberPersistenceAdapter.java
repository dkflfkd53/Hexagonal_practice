package com.example.hexagonal_practice.account.adapter.out.persistence.member;

import com.example.hexagonal_practice.account.application.port.out.MemberRepositoryPort;
import com.example.hexagonal_practice.account.domain.Member;
import com.example.hexagonal_practice.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class MemberPersistenceAdapter implements MemberRepositoryPort {
    private final MemberRepository memberRepository;

    public void saveMember(Member member) {
        memberRepository.save(member);
    }
}
