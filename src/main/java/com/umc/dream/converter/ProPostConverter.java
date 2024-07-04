package com.umc.dream.converter;

import com.umc.dream.domain.Post;
import com.umc.dream.domain.User;
import com.umc.dream.domain.enums.Type;
import com.umc.dream.dto.ProRequestDTO;
import com.umc.dream.dto.ProResponseDTO;

public class ProPostConverter {

    public static ProResponseDTO.CreateResultDTO toProPostResultDTO(Post post) {
        return ProResponseDTO.CreateResultDTO.builder()
                .name(post.getWriter().getName())
                .postId(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .proName(post.getPro().getName())
                .createdAt(post.getPro().getCreatedDate())
                .build();
    }

    public static Post toProPost(ProRequestDTO.CreateRequestDTO request, User writer, User pro) {
        return Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .type(Type.PRO)
                .writer(writer)
                .pro(pro)
                .build();
    }

}
