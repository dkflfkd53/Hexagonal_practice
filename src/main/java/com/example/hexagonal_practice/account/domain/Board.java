package com.example.hexagonal_practice.account.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

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
    private User user;

    @OneToMany(mappedBy = "boardId", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Member> members;

    private String title;

    private String content;

    private Long memberNumber;

    public void joinMember(Member member) {
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
