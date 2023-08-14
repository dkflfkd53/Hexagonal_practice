package com.example.hexagonal_practice.account.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String title;

    private String content;

    private Long memberNumber;

    public void joinMember() {
        memberNumber++;
    }

    public void modifyBoard(String title, String content, Long memberNumber) {
        this.title = title;
        this.content = content;
        this.memberNumber = memberNumber;
    }
}
