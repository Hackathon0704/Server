package com.umc.dream.controller;

import com.umc.dream.apiPayload.ApiResponse;
import com.umc.dream.converter.DreamConverter;
import com.umc.dream.converter.FollowConverter;
import com.umc.dream.domain.Dream;
import com.umc.dream.domain.Follow;
import com.umc.dream.dto.*;
import com.umc.dream.service.DreamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DreamController {

    private DreamService dreamService;

    @PostMapping("/diary")
    @Operation(summary = "꿈 일기 생성 API", description = "꿈 일기 생성 API입니다")
    @Parameters({
            @Parameter(name = "dreamRequestDto", description = "상세 필드는 노션 API 명세를 참고!"),
    })
    public ApiResponse<AddDreamResponseDto> createDream(@RequestBody DreamRequestDto dreamRequestDto) {
        Dream dream = dreamService.createDream(dreamRequestDto);
        AddDreamResponseDto addDreamResponseDto = DreamConverter.toAddDreamResponse(dream);
        return ApiResponse.onSuccess(addDreamResponseDto);
    }

    @GetMapping("/diary/{user_id}")
    @Operation(summary = "내 꿈 일기 목록 API", description = "내 꿈 일기 목록 조회 API입니다")
    @Parameters({
            @Parameter(name = "user_id", description = "꿈 일기 목록을 조회하고자하는 사용자의 pk"),
    })
    private ApiResponse<List<GetDreamResponseDto>> GetDream(@RequestParam Long user_id) {
        List<GetDreamResponseDto> getDreamResponseDtos = dreamService.getDream(user_id);
        return ApiResponse.onSuccess(getDreamResponseDtos);
    }

    @GetMapping("/diary/{user_id}/{diary_id}")
    @Operation(summary = "내 꿈 일기 상세 조회", description = "내 꿈 일기 상세 조회 API입니다")
    @Parameters({
            @Parameter(name = "user_id", description = "자신의 pk"),
            @Parameter(name = "dream_id", description = "꿈 일기의 pk")
    })
    private ApiResponse<ViewDreamResponseDto> ViewDream(@RequestParam Long user_id, @RequestParam Long dream_id) {
        ViewDreamResponseDto viewDreamResponseDto = dreamService.viewDream(user_id, dream_id);
        return ApiResponse.onSuccess(viewDreamResponseDto);
    }
}
