package com.umc.dream.domain;

import com.umc.dream.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hashtag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tag;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "dream_id")
    private Dream dream;

    @Builder
    public Hashtag(String tag, Dream dream) {
        this.tag = tag;
        this.dream = dream;
    }
}
