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

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.ALL})
    private User user;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.ALL})
    private List<User> members;

    private String title;

    private String content;

    private Long memberNumber;

    public void joinMember(User member) {
        members.add(member);
    }

    public void addMember() {
        memberNumber++;
    }

    public void modifyBoard(String title, String content, Long memberNumber) {
        this.title = title;
        this.content = content;
        this.memberNumber = memberNumber;
    }

}
