package com.umc.dream.controller;

import com.umc.dream.apiPayload.ApiResponse;
import com.umc.dream.converter.FollowConverter;
import com.umc.dream.domain.Follow;
import com.umc.dream.dto.FollowRequestDto;
import com.umc.dream.dto.FollowResponseDto;
import com.umc.dream.dto.ViewFollowResponseDto;
import com.umc.dream.service.FollowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FollowController {

    private final FollowService followService;

    @PostMapping("/user/follow")
    public ApiResponse<FollowResponseDto> follow(@RequestBody FollowRequestDto followRequestDto) {
        Follow f = followService.follow(followRequestDto);
        FollowResponseDto followResponseDto = FollowConverter.toFollowResponse(f);
        return ApiResponse.onSuccess(followResponseDto);
    }

    @DeleteMapping("/user/followCancel")
    public ApiResponse<?> followCancel(@RequestBody FollowRequestDto followRequestDto) {
        followService.followCancel(followRequestDto);
        return ApiResponse.onSuccess("팔로우 취소됨");
    }

    @GetMapping("/user/{user_id}/following")
    public ApiResponse<List<ViewFollowResponseDto>> viewFollowings(@PathVariable Long user_id) {
        List<ViewFollowResponseDto> viewFollowResponseDtos = followService.viewFollowings(user_id);
        return ApiResponse.onSuccess(viewFollowResponseDtos);
    }
}
