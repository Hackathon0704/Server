package com.umc.dream.dto;

import lombok.Getter;

public class FriendRequestDTO {

    @Getter
    public static class CreateFriendRequestDTO {
        Long userId;  // 유저 id
        String title;
        String content;
    }

    @Getter
    public static class GetAllProPostRequestDTO {
        Long userId;
    }
}
