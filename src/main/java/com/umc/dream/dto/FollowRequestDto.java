package com.umc.dream.dto;

import com.umc.dream.domain.Follow;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FollowRequestDto {
    private Long followerId;
    private Long acceptorId;

    @Builder
    public FollowRequestDto(Follow follow) {
        this.followerId = follow.getFollower().getId();
        this.acceptorId = follow.getAcceptor().getId();
    }
}
