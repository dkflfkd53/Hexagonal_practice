package com.example.hexagonal_practice.account.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Board board;

    private String username;

    public void joinBoard() {
        Long memberNumber = board.getMemberNumber();
        memberNumber++;
    }
}
