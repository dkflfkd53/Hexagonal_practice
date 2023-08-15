package com.example.hexagonal_practice.account.adapter.out.persistence.board;

import com.example.hexagonal_practice.account.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
