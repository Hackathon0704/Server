package com.umc.dream.converter;

import com.umc.dream.domain.Dream;
import com.umc.dream.domain.Post;
import com.umc.dream.domain.User;
import com.umc.dream.dto.PostRequestDTO;
import com.umc.dream.dto.PostResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public static PostResponseDTO.CommunityPostDTO toCommunityPostDTO(Post post) {
        return PostResponseDTO.CommunityPostDTO
                .builder()
                .postId(post.getId())
                .title(post.getTitle())
                .writer(post.getWriter().getName())
                .createdAt(LocalDate.from(post.getCreatedDate()))
                .build();
    }

    public static PostResponseDTO.CommunityPostListDTO toCommunityPostListDTO(Page<Post> communityPostList) {
        List<PostResponseDTO.CommunityPostDTO> communityPostDTOList = communityPostList.stream()
                .map(PostConverter::toCommunityPostDTO)
                .collect(Collectors.toList());

        return PostResponseDTO.CommunityPostListDTO.builder()
                .isLast(communityPostList.isLast())
                .isFirst(communityPostList.isFirst())
                .totalPage(communityPostList.getTotalPages())
                .totalElements(communityPostList.getTotalElements())
                .listSize(communityPostDTOList.size())
                .communityPostDTOList(communityPostDTOList)
                .build();
    }
}
