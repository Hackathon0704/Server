package com.umc.dream.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ProResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateResultDTO {
        String name;    // 유저 이름
        Long postId;
        String title;
        String content;
        String proName; // 전문가 이름
        LocalDateTime createdAt;
    }

}
