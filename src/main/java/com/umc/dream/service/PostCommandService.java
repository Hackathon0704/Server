package com.umc.dream.service;

import com.umc.dream.domain.Comment;
import com.umc.dream.domain.Post;
import com.umc.dream.dto.PostRequestDTO;

public interface PostCommandService {
    Post createCommunityPost(PostRequestDTO.CreateCommunityDTO request);
    Comment createComment(Long postId, PostRequestDTO.CreateCommentDTO request);
    void deletePost(Long postId);
}
