package com.umc.dream.converter;

import com.umc.dream.domain.Dream;
import com.umc.dream.domain.Post;
import com.umc.dream.domain.User;
import com.umc.dream.dto.PostRequestDTO;
import com.umc.dream.dto.PostResponseDTO;

public class PostConverter {

    public static PostResponseDTO.CreateCommunityPostResultDTO toCreateCommunityPostResultDTO(Post post) {
        return PostResponseDTO.CreateCommunityPostResultDTO
                .builder()
                .postId(post.getId())
                .createdAt(post.getCreatedDate())
                .build();
    }

    public static Post toPost(PostRequestDTO.CreateCommunityDTO request, User user, Dream dream) {
        return Post.builder()
                .writer(user)
                .dream(dream)
                .title(request.getTitle())
                .content(request.getContent())
                .type(request.getType())
                .build();
    }
}
