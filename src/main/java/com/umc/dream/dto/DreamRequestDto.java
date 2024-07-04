package com.umc.dream.dto;

import com.umc.dream.domain.Feeling;
import com.umc.dream.domain.Hashtag;
import com.umc.dream.domain.People;
import com.umc.dream.domain.Place;
import com.umc.dream.domain.enums.DreamCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
public class DreamRequestDto {
    private Long users_id;
    private LocalDate date;
    private LocalDateTime sleepTime;
    private LocalDateTime wakeUpTime;
    private String title;
    private String content;
    private DreamCategory category;
    private List<String> people;
    private List<String> place;
    private List<String> feeling;
    private List<String> hashtag;
}
