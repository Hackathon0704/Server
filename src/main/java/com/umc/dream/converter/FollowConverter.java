package com.umc.dream.converter;

import com.umc.dream.domain.Follow;
import com.umc.dream.dto.FollowResponseDto;

public class FollowConverter {

    public static FollowResponseDto toFollowResponse(Follow follow) {
        return FollowResponseDto.builder()
                .updatedAt(follow.getFollower().getLastModifiedDate())
                .build();
    }
}
