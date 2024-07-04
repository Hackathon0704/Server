package com.umc.dream.controller;

import com.umc.dream.apiPayload.ApiResponse;
import com.umc.dream.converter.ProPostConverter;
import com.umc.dream.domain.Post;
import com.umc.dream.dto.ProRequestDTO;
import com.umc.dream.dto.ProResponseDTO;
import com.umc.dream.service.ProService.ProService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/pro")
public class ProController {

    private final ProService proService;

    @Operation(summary = "전문가 게시글 작성 API")
    @PostMapping
    public ApiResponse<ProResponseDTO.CreateResultDTO> createProPost(@RequestBody ProRequestDTO.CreateRequestDTO request){
        Post post = proService.createProPost(request);
        return ApiResponse.onSuccess(ProPostConverter.toProPostResultDTO(post));
    }

    @Operation(summary = "전문가 전체 게시글 조회 API")
    @GetMapping
    public ApiResponse<ProResponseDTO.ProPostListDTO> getAllProPostList(@RequestParam(name = "userId") Long userId) {
        List<Post> posts = proService.getAllProPostList(userId);
        return ApiResponse.onSuccess(ProPostConverter.toProPostListDTO(posts));
    }

}
