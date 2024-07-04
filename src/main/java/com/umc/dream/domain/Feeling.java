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
public class Feeling extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String feel;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "dream_id")
    private Dream dream;

    @Builder
    public Feeling(String feel, Dream dream) {
        this.feel = feel;
        this.dream = dream;
    }
}
