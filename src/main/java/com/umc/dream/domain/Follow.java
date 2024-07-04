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
public class Follow extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "follower_id")
    private User follower; // 친추 거는 사람

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "acceptor_id")
    private User acceptor; // 친추 당하는 사람

    @Builder
    public Follow(User follower, User acceptor) {
        this.follower = follower;
        this.acceptor = acceptor;
    }
}
