package com.umc.dream.dto;

import com.umc.dream.domain.enums.DreamCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewDreamResponseDto {
    private Long dream_id;
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
