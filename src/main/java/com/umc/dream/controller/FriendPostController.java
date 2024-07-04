package com.umc.dream.controller;

import com.umc.dream.apiPayload.ApiResponse;
import com.umc.dream.converter.FriendPostConverter;
import com.umc.dream.domain.Post;
import com.umc.dream.dto.FriendRequestDTO;
import com.umc.dream.dto.FriendResponseDTO;
import com.umc.dream.service.FriendService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/following")
public class FriendPostController {

    private final FriendService friendService;

    @Operation(summary = "친구 게시물 생성 API")
    @PostMapping
    public ApiResponse<FriendResponseDTO.CreateResultDTO> createFriendPost(@RequestBody FriendRequestDTO.CreateFriendRequestDTO request){
        Post post = friendService.createFriendPost(request);
        return ApiResponse.onSuccess(FriendPostConverter.toFriendPostResultDTO(post));
    }

    @Operation(summary = "친구 전체 게시물 조회 API")
    @GetMapping
    public ApiResponse<FriendResponseDTO.FriendPostListDTO> getAllFriendPostList(@RequestParam(name = "userId") Long userId) {
        List<Post> posts = friendService.getAllFriendPostList(userId);
        return ApiResponse.onSuccess(FriendPostConverter.toFriendPostListDTO(posts));
    }
}
