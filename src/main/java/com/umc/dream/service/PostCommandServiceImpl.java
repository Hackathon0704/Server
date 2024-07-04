package com.umc.dream.service;

import com.umc.dream.apiPayload.code.status.ErrorStatus;
import com.umc.dream.apiPayload.exception.handler.TempHandler;
import com.umc.dream.converter.PostConverter;
import com.umc.dream.domain.Dream;
import com.umc.dream.domain.Post;
import com.umc.dream.domain.User;
import com.umc.dream.dto.PostRequestDTO;
import com.umc.dream.repository.DreamRepository;
import com.umc.dream.repository.PostRepository;
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

    @Override
    public Post createCommunityPost(PostRequestDTO.CreateCommunityDTO request) {
        User findUser = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Dream findDream = dreamRepository.findById(request.getDreamId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.DREAM_NOT_FOUND));

        Post newPost = PostConverter.toPost(request, findUser, findDream);

        return postRepository.save(newPost);
    }
}
