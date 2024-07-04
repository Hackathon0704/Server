package com.umc.dream.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetDreamResponseDto {
    private String title;
    private LocalDate date;
    private String place;
    private String people;
    private String feeling;
    private String hashtag;
}
