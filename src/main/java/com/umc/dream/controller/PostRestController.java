package com.umc.dream.controller;


import com.umc.dream.apiPayload.ApiResponse;
import com.umc.dream.converter.PostConverter;
import com.umc.dream.domain.Post;
import com.umc.dream.dto.PostRequestDTO;
import com.umc.dream.dto.PostResponseDTO;
import com.umc.dream.service.PostCommandService;
import com.umc.dream.service.PostQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    @Operation(summary = "커뮤니티 게시글 전체 조회 API", description = "query string으로 page를 받고, 한 페이지당 게시물 10개 입니다. 페이지는 0부터 입력해주세요.")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0이 1 페이지 입니다."),
    })
    public ApiResponse<PostResponseDTO.PostPreviewListDTO> getCommunityPostList(@RequestParam(name = "page") Integer page) {
        Page<Post> communityPostList = postQueryService.getCommunityPostList(page);
        return ApiResponse.onSuccess(PostConverter.toPostPreviewListDTO(communityPostList));
    }

    @GetMapping("/{postId}")
    @Operation(summary = "특정 게시글 상세 조회 API", description = "postId를 받아 게시글의 세부 내용과 댓글을 조회합니다.")
    public ApiResponse<PostResponseDTO.PostDetailDTO> getPostDetail(@PathVariable Long postId) {
        Post postDetail = postQueryService.getPostDetail(postId);
        return ApiResponse.onSuccess(PostConverter.toPostDetailDTO(postDetail));
    }

}
