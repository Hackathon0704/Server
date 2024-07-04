package com.umc.dream.converter;

import com.umc.dream.domain.Comment;
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

    public static PostResponseDTO.PostPreviewDTO toPostPreviewDTO(Post post) {
        return PostResponseDTO.PostPreviewDTO
                .builder()
                .postId(post.getId())
                .title(post.getTitle())
                .content(post.getContent()) // 미리보기이므로 한 15자로 제한
                .writer(post.getWriter().getName())
                .createdAt(LocalDate.from(post.getCreatedDate()))
                .build();
    }

    public static PostResponseDTO.PostPreviewListDTO toPostPreviewListDTO(Page<Post> communityPostList) {
        List<PostResponseDTO.PostPreviewDTO> communityPostDTOList = communityPostList.stream()
                .map(PostConverter::toPostPreviewDTO)
                .collect(Collectors.toList());

        return PostResponseDTO.PostPreviewListDTO.builder()
                .isLast(communityPostList.isLast())
                .isFirst(communityPostList.isFirst())
                .totalPage(communityPostList.getTotalPages())
                .totalElements(communityPostList.getTotalElements())
                .listSize(communityPostDTOList.size())
                .communityPostDTOList(communityPostDTOList)
                .build();
    }

    public static PostResponseDTO.CommentDetailDTO toCommentDetailDTO(Comment comment) {
        return PostResponseDTO.CommentDetailDTO
                .builder()
                .commentId(comment.getId())
                .writer(comment.getUser().getName())
                .content(comment.getReply())
                .build();
    }

    public static PostResponseDTO.PostDetailDTO toPostDetailDTO(Post post) {

        List<PostResponseDTO.CommentDetailDTO> commentDetailDTOList = post.getCommentList().stream()
                .map(PostConverter::toCommentDetailDTO)
                .collect(Collectors.toList());

        return PostResponseDTO.PostDetailDTO
                .builder()
                .postId(post.getId())
                .writer(post.getWriter().getName())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(LocalDate.from(post.getCreatedDate()))
                .commentDetailDTOList(commentDetailDTOList)
                .build();
    }
}
