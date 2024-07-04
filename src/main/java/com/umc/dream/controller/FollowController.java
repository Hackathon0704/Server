package com.umc.dream.controller;

import com.umc.dream.apiPayload.ApiResponse;
import com.umc.dream.converter.FollowConverter;
import com.umc.dream.domain.Follow;
import com.umc.dream.dto.FollowRequestDto;
import com.umc.dream.dto.FollowResponseDto;
import com.umc.dream.dto.ViewFollowResponseDto;
import com.umc.dream.service.FollowService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FollowController {

    private final FollowService followService;

    @PostMapping("/user/follow")
    @Operation(summary = "친구 추가(팔로우) API", description = "친구 추가 API입니다")
    @Parameters({
            @Parameter(name = "followRequestDto", description = "followerId(팔로우 하는 사람의 pk)와 acceptorId(팔로우 당하는 사람의 pk)를 담고있는 DTO 객체"),
    })
    public ApiResponse<FollowResponseDto> follow(@RequestBody FollowRequestDto followRequestDto) {
        Follow f = followService.follow(followRequestDto);
        FollowResponseDto followResponseDto = FollowConverter.toFollowResponse(f);
        return ApiResponse.onSuccess(followResponseDto);
    }

    @DeleteMapping("/user/followCancel")
    @Operation(summary = "친구 삭제(팔로우 취소) API", description = "친구 삭제 API입니다")
    @Parameters({
            @Parameter(name = "followRequestDto", description = "followerId(팔로우 하는 사람의 pk)와 acceptorId(팔로우 당하는 사람의 pk)를 담고있는 DTO 객체"),
    })
    public ApiResponse<?> followCancel(@RequestBody FollowRequestDto followRequestDto) {
        followService.followCancel(followRequestDto);
        return ApiResponse.onSuccess("팔로우 취소됨");
    }

    @GetMapping("/user/{user_id}/following")
    @Operation(summary = "친구 목록 조회 API", description = "친구 목록 조회 API입니다")
    @Parameters({
            @Parameter(name = "user_id", description = "친구 목록을 조회하고자하는 사용자의 pk"),
    })
    public ApiResponse<List<ViewFollowResponseDto>> viewFollowings(@PathVariable Long user_id) {
        List<ViewFollowResponseDto> viewFollowResponseDtos = followService.viewFollowings(user_id);
        return ApiResponse.onSuccess(viewFollowResponseDtos);
    }
}
