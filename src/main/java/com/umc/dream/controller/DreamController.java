package com.umc.dream.controller;

import com.umc.dream.apiPayload.ApiResponse;
import com.umc.dream.converter.DreamConverter;
import com.umc.dream.converter.FollowConverter;
import com.umc.dream.domain.Dream;
import com.umc.dream.domain.Follow;
import com.umc.dream.dto.*;
import com.umc.dream.service.DreamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DreamController {

    private DreamService dreamService;

    @PostMapping("/diary")
    public ApiResponse<AddDreamResponseDto> createDream(@RequestBody DreamRequestDto dreamRequestDto) {
        Dream dream = dreamService.createDream(dreamRequestDto);
        AddDreamResponseDto addDreamResponseDto = DreamConverter.toAddDreamResponse(dream);
        return ApiResponse.onSuccess(addDreamResponseDto);
    }

    @GetMapping("/diary/{user_id}")
    private ApiResponse<List<GetDreamResponseDto>> GetDream(@RequestParam Long user_id) {
        List<GetDreamResponseDto> getDreamResponseDtos = dreamService.getDream(user_id);
        return ApiResponse.onSuccess(getDreamResponseDtos);
    }

    @GetMapping("/diary/{user_id}/{diary_id}")
    private ApiResponse<ViewDreamResponseDto> ViewDream(@RequestParam Long user_id, @RequestParam Long dream_id) {
        ViewDreamResponseDto viewDreamResponseDto = dreamService.viewDream(user_id, dream_id);
        return ApiResponse.onSuccess(viewDreamResponseDto);
    }
}
