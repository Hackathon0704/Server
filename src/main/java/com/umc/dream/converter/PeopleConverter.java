package com.umc.dream.converter;

import com.umc.dream.domain.Dream;
import com.umc.dream.domain.People;
import com.umc.dream.domain.User;
import com.umc.dream.dto.DreamRequestDto;

public class PeopleConverter {
    public static People toPeople(String name, Dream dream) {
        return People.builder()
                .name(name)
                .dream(dream)
                .build();
    }
}
