package com.umc.dream.converter;

import com.umc.dream.domain.Dream;
import com.umc.dream.domain.Feeling;
import com.umc.dream.domain.Place;

public class PlaceConverter {
    public static Place toPlace(String location, Dream dream) {
        return Place.builder()
                .location(location)
                .dream(dream)
                .build();
    }
}
