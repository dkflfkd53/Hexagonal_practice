package com.example.hexagonal_practice.account.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY)
    private List<User> users;

    private String title;

    private String content;

    private Long memberNumber;

    public void joinMember(User user) {
        users.add(user);
    }

    public void cancelMember(User user) {
        users.remove(user);
    }

    public void modifyBoard(String title, String content, Long memberNumber) {
        this.title = title;
        this.content = content;
        this.memberNumber = memberNumber;
    }

}
