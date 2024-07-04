package com.umc.dream.converter;

import com.umc.dream.domain.*;
import com.umc.dream.dto.*;

import java.util.List;

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
    public static ViewDreamResponseDto toViewDreamResponse(Dream dream, List<String> feels, List<String> name, List<String> location, List<String> tag) {
        return ViewDreamResponseDto.builder()
                .dream_id(dream.getId())
                .date(dream.getDate())
                .sleepTime(dream.getSleepTime())
                .wakeUpTime(dream.getWakeUpTime())
                .title(dream.getTitle())
                .content(dream.getContent())
                .category(dream.getCategory())
                .people(name)
                .place(location)
                .feeling(feels)
                .hashtag(tag)
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
