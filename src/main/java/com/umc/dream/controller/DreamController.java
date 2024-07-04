package com.umc.dream.controller;

import com.umc.dream.apiPayload.ApiResponse;
import com.umc.dream.converter.DreamConverter;
import com.umc.dream.converter.FollowConverter;
import com.umc.dream.domain.Dream;
import com.umc.dream.domain.Follow;
import com.umc.dream.dto.AddDreamResponseDto;
import com.umc.dream.dto.DreamRequestDto;
import com.umc.dream.dto.FollowRequestDto;
import com.umc.dream.dto.FollowResponseDto;
import com.umc.dream.service.DreamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
