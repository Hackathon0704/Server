package com.umc.dream.converter;

import com.umc.dream.domain.*;
import com.umc.dream.dto.AddDreamResponseDto;
import com.umc.dream.dto.DreamRequestDto;
import com.umc.dream.dto.FollowResponseDto;
import com.umc.dream.dto.GetDreamResponseDto;

public class DreamConverter {
    public static AddDreamResponseDto toAddDreamResponse(Dream dream) {
        return AddDreamResponseDto.builder()
                .dream_id(dream.getId())
                .build();
    }
    public static GetDreamResponseDto toGetDreamResponse(Dream dream, People people, Place place, Feeling feeling, Hashtag hashtag) {
        return GetDreamResponseDto.builder()
                .title(dream.getTitle())
                .date(dream.getDate())
                .people(people.getName())
                .place(place.getLocation())
                .feeling(feeling.getFeel())
                .hashtag(hashtag.getTag())
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
