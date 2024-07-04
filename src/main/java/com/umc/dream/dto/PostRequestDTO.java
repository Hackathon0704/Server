package com.umc.dream.dto;

import com.umc.dream.domain.enums.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class PostRequestDTO {

    @Getter
    public static class CreateCommunityDTO {
        @NotNull(message = "작성자의 pk를 입력해주세요.")
        private Long userId;
        private Long dreamId;
        @NotBlank(message = "글의 제목은 필수입니다.")
        private String title;
        @NotBlank(message = "글의 내용은 필수입니다.")
        private String content;
        @NotBlank(message = "게시글의 유형은 필수입니다.")
        private Type type;

    }

    @Getter
    public static class CreateCommentDTO {
        @NotNull(message = "작성자의 pk를 입력해주세요.")
        private Long writerId;
        @NotBlank(message = "댓글 내용은 필수입니다.")
        private String reply;
    }
}
