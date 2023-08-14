package com.example.hexagonal_practice.account.adapter.out.persistence.member;

import com.example.hexagonal_practice.account.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
