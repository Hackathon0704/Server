package com.umc.dream.service.ProService;

import com.umc.dream.apiPayload.code.status.ErrorStatus;
import com.umc.dream.apiPayload.exception.GeneralException;
import com.umc.dream.converter.ProPostConverter;
import com.umc.dream.domain.Post;
import com.umc.dream.domain.User;
import com.umc.dream.domain.enums.Type;
import com.umc.dream.dto.ProRequestDTO;
import com.umc.dream.repository.PostRepository;
import com.umc.dream.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProService implements ProServiceImpl{

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public Post createProPost(ProRequestDTO.CreateRequestDTO request) {
        User writer = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new GeneralException(ErrorStatus._BAD_REQUEST));
        User pro = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new GeneralException(ErrorStatus._BAD_REQUEST));

        Post post = ProPostConverter.toProPost(request, writer, pro);
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllProPostList(Long userId) {
        return postRepository.findAllByWriterIdAndType(userId, Type.PRO);
    }
}
