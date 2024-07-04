package com.umc.dream.service;

import com.umc.dream.apiPayload.code.status.ErrorStatus;
import com.umc.dream.apiPayload.exception.GeneralException;
import com.umc.dream.domain.Follow;
import com.umc.dream.domain.User;
import com.umc.dream.dto.FollowRequestDto;
import com.umc.dream.dto.ViewFollowResponseDto;
import com.umc.dream.repository.FollowRepository;
import com.umc.dream.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;
    @Transactional
    public Follow follow(FollowRequestDto followRequestDto) {
        User follower = userRepository.findById(followRequestDto.getFollowerId())
                .orElseThrow(() -> new GeneralException(ErrorStatus._BAD_REQUEST));
        User acceptor = userRepository.findById(followRequestDto.getAcceptorId())
                .orElseThrow(() -> new GeneralException(ErrorStatus._BAD_REQUEST));
        Follow f = Follow.builder()
                .follower(follower)
                .acceptor(acceptor)
                .build();
        followRepository.save(f);
        return f;
    }

    @Transactional
    public void followCancel(FollowRequestDto followRequestDto) {
        User follower = userRepository.findById(followRequestDto.getFollowerId())
                .orElseThrow(() -> new GeneralException(ErrorStatus._BAD_REQUEST));
        User acceptor = userRepository.findById(followRequestDto.getAcceptorId())
                .orElseThrow(() -> new GeneralException(ErrorStatus._BAD_REQUEST));
        Follow f = followRepository.findByFollowerAndAcceptor(follower,acceptor);
        followRepository.delete(f);
    }

    @Transactional
    public List<ViewFollowResponseDto> viewFollowings(Long memberId) {
        List<Follow> follows = followRepository.findAllByFollower_Id(memberId);
        List<ViewFollowResponseDto> viewFollowResponseDtos = new ArrayList<>();
        for(Follow follow : follows) {
            User user = follow.getAcceptor();
            ViewFollowResponseDto viewFollowResponseDto = ViewFollowResponseDto.builder()
                    .userId(user.getId())
                    .name(user.getName())
                    .build();
            viewFollowResponseDtos.add(viewFollowResponseDto);
        }
        return viewFollowResponseDtos;
    }
}
