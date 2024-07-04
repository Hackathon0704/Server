package com.umc.dream.controller;


import com.umc.dream.apiPayload.ApiResponse;
import com.umc.dream.converter.PostConverter;
import com.umc.dream.domain.Post;
import com.umc.dream.dto.PostRequestDTO;
import com.umc.dream.dto.PostResponseDTO;
import com.umc.dream.service.PostCommandService;
import com.umc.dream.service.PostQueryService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostRestController {

    private final PostCommandService postCommandService;
    private final PostQueryService postQueryService;

    @PostMapping("/community")
    @Operation(summary = "커뮤니티 게시글 등록 API",description = "친구, 전문가와 공유하는 게시글이 아닌 커뮤니티에 전체 공유되는 게시글을 저장하는 API 입니다")
    public ApiResponse<PostResponseDTO.CreateCommunityPostResultDTO> createCommunityPost(@RequestBody @Valid PostRequestDTO.CreateCommunityDTO request) {
        Post savedCommunityPost = postCommandService.createCommunityPost(request);
        return ApiResponse.onSuccess(PostConverter.toCreateCommunityPostResultDTO(savedCommunityPost));
    }

    @GetMapping("/community")
    @Operation(summary = "커뮤니티 게시글 전체 조회 API",description = "")
    public ApiResponse getCommunityPostList(@RequestParam(name = "page") Integer page) {
        return null;
    }

}
