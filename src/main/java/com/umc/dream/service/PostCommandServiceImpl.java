package com.umc.dream.service;

import com.umc.dream.apiPayload.code.status.ErrorStatus;
import com.umc.dream.apiPayload.exception.handler.TempHandler;
import com.umc.dream.converter.PostConverter;
import com.umc.dream.domain.Comment;
import com.umc.dream.domain.Dream;
import com.umc.dream.domain.Post;
import com.umc.dream.domain.User;
import com.umc.dream.dto.PostRequestDTO;
import com.umc.dream.repository.CommentRepository;
import com.umc.dream.repository.DreamRepository;
import com.umc.dream.repository.PostRepository;
import com.umc.dream.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostCommandServiceImpl implements PostCommandService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final DreamRepository dreamRepository;
    private final CommentRepository commentRepository;

    @Override
    public Post createCommunityPost(PostRequestDTO.CreateCommunityDTO request) {
        User findUser = findUserByUserId(request.getUserId());

        Dream findDream = dreamRepository.findById(request.getDreamId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.DREAM_NOT_FOUND));

        Post newPost = PostConverter.toPost(request, findUser, findDream);

        return postRepository.save(newPost);
    }



    @Override
    public Comment createComment(Long postId, PostRequestDTO.CreateCommentDTO dto) {
        Post findPost = findPostByPostId(postId);

        User findUser = findUserByUserId(dto.getWriterId());

        Comment newComment = PostConverter.toComment(dto, findUser, findPost);

        return commentRepository.save(newComment);
    }

    @Override
    public void deletePost(Long postId) {
        Post findPost = findPostByPostId(postId);
        postRepository.delete(findPost);
    }

    private User findUserByUserId(Long userId) {
        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return findUser;
    }

    private Post findPostByPostId(Long postId) {
        Post findPost = postRepository.findById(postId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.POST_NOT_FOUND));
        return findPost;
    }
}
