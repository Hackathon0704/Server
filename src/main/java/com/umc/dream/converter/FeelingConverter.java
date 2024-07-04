package com.umc.dream.converter;

import com.umc.dream.domain.Dream;
import com.umc.dream.domain.Feeling;
import com.umc.dream.domain.Hashtag;

public class FeelingConverter {
    public static Feeling toFeeling(String feel, Dream dream) {
        return Feeling.builder()
                .feel(feel)
                .dream(dream)
                .build();
    }
}
