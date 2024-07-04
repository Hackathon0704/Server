package com.umc.dream.converter;

import com.umc.dream.domain.Dream;
import com.umc.dream.domain.Follow;
import com.umc.dream.domain.User;
import com.umc.dream.dto.AddDreamResponseDto;
import com.umc.dream.dto.DreamRequestDto;
import com.umc.dream.dto.FollowResponseDto;

public class DreamConverter {
    public static AddDreamResponseDto toAddDreamResponse(Dream dream) {
        return AddDreamResponseDto.builder()
                .dream_id(dream.getId())
                .build();
    }

    public static Dream toDream(DreamRequestDto dreamRequestDto, User user) {
        return Dream.builder()
                .user(user)
                .date(dreamRequestDto.getDate())
                .sleepTime(dreamRequestDto.getSleepTime())
                .wakeUpTime(dreamRequestDto.getWakeUpTime())
                .title(dreamRequestDto.getTitle())
                .content(dreamRequestDto.getContent())
                .category(dreamRequestDto.getCategory())
                .build();
    }
}
