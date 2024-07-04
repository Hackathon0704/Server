package com.umc.dream.converter;

import com.umc.dream.domain.Post;
import com.umc.dream.domain.User;
import com.umc.dream.domain.enums.Type;
import com.umc.dream.dto.FriendRequestDTO;
import com.umc.dream.dto.FriendResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class FriendPostConverter {
    public static Post toFriendPost(FriendRequestDTO.CreateFriendRequestDTO request, User writer) {
        return Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .type(Type.FRIENDS)
                .writer(writer)
                .build();
    }

    public static FriendResponseDTO.CreateResultDTO toFriendPostResultDTO(Post post) {
        return FriendResponseDTO.CreateResultDTO.builder()
                .name(post.getWriter().getName())
                .postId(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedDate())
                .build();
    }

    public static FriendResponseDTO.FriendPostListDTO toFriendPostListDTO(List<Post> posts) {
        List<FriendResponseDTO.CreateResultDTO> postDTOs = posts.stream()
                .map(post -> FriendResponseDTO.CreateResultDTO.builder()
                        .name(post.getWriter().getName())
                        .postId(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .createdAt(post.getCreatedDate())
                        .build())
                .collect(Collectors.toList());
        return new FriendResponseDTO.FriendPostListDTO(postDTOs);
    }
}
