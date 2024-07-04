package com.umc.dream.domain;

import com.umc.dream.domain.enums.Type;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "writer_id")
    private User writer;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "pro_id")
    private User pro;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "dream_id")
    private Dream dream;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    @Builder
    public Post(String title, String content, Type type, User writer, User pro, Dream dream) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.writer = writer;
        this.pro = pro;
        this.dream = dream;
    }
}