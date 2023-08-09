package com.example.hexagonal_practice.domain.account.adapter.out.persistence;

import com.example.hexagonal_practice.domain.account.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
