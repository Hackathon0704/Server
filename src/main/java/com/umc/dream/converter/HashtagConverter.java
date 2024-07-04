package com.umc.dream.converter;

import com.umc.dream.domain.Dream;
import com.umc.dream.domain.Hashtag;
import com.umc.dream.domain.People;

public class HashtagConverter {
    public static Hashtag toHashtag(String tag, Dream dream) {
        return Hashtag.builder()
                .tag(tag)
                .dream(dream)
                .build();
    }
}
