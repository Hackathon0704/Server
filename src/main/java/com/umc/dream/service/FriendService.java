package com.umc.dream.service;

import com.umc.dream.apiPayload.code.status.ErrorStatus;
import com.umc.dream.apiPayload.exception.GeneralException;
import com.umc.dream.converter.FriendPostConverter;
import com.umc.dream.domain.Post;
import com.umc.dream.domain.User;
import com.umc.dream.domain.enums.Type;
import com.umc.dream.dto.FriendRequestDTO;
import com.umc.dream.repository.PostRepository;
import com.umc.dream.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Post createFriendPost(FriendRequestDTO.CreateFriendRequestDTO request) {
        User writer = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new GeneralException(ErrorStatus._BAD_REQUEST));
        Post post = FriendPostConverter.toFriendPost(request, writer);
        return postRepository.save(post);
    }

    public List<Post> getAllFriendPostList(Long userId) {
        return postRepository.findAllByWriterIdAndType(userId, Type.FRIENDS);
    }

}
