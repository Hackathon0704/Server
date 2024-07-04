package com.umc.dream.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public enum DreamCategory {
    NORMAL("일상"),
    NIGHTMARE("악몽"),
    REPEATED_DREAM("반복되는 꿈"),
    LUCID_DREAM("자각몽"),
    PRECOGNITIVE_DREAM("예지몽");

    @JsonValue
    private final String value;

    DreamCategory(String value) {
        this.value = value;
    }

    @JsonCreator // Json -> Object, 역직렬화 수행하는 메서드
    public static DreamCategory from(String param) {
        for (DreamCategory dreamCategory : DreamCategory.values()) {
            if (dreamCategory.getValue().equals(param)) {
                return dreamCategory;
            }
        }
        log.debug("dreamCategory.from() exception occur param: {}", param);
        return null;
    }
}
