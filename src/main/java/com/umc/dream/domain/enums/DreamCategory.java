package com.umc.dream.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public enum DreamCategory {
    NORMAL("일반"),
    SOSO("그냥그래요"),
    GOOD("온수가 빨라요");

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
        log.debug("HotWaterStatus.from() exception occur param: {}", param);
        return null;
    }
}
