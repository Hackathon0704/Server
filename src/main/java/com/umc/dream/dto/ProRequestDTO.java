package com.umc.dream.dto;

import lombok.Getter;

public class ProRequestDTO {

    @Getter
    public static class CreateRequestDTO {
        Long userId;  // 유저 id
        Long proId; // 전문가 id
        String title;
        String content;
    }
}
