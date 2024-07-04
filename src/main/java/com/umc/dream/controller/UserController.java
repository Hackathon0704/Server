package com.umc.dream.controller;

import com.umc.dream.apiPayload.ApiResponse;
import com.umc.dream.domain.User;
import com.umc.dream.dto.UserRequestDTO;
import com.umc.dream.dto.UserResponseDTO;
import com.umc.dream.service.UserService.UserService;
import com.umc.dream.converter.UserConverter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원가입 API")
    @PostMapping("/join")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody UserRequestDTO.JoinDto request){
        User user = userService.join(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

    @Operation(summary = "로그인 API")
    @PostMapping("/login")
    public ApiResponse<UserResponseDTO.LoginResultDTO> login(@RequestBody UserRequestDTO.LoginDto request){
        User user = userService.login(request);
        return ApiResponse.onSuccess(UserConverter.toLoginResultDTO(user));
    }

    @Operation(summary = "아이디 중복확인 API", description = "중복이면 true, 중복이 아니면 false를 반환합니다.")
    @PostMapping("/check-account")
    public ApiResponse<UserResponseDTO.CheckAccountResultDTO> checkAccount(@RequestBody UserRequestDTO.CheckAccountRequestDto request){
        boolean isDuplicated = userService.CheckAccount(request);
        return ApiResponse.onSuccess(UserConverter.toCheckAccountResultDTO(isDuplicated));
    }

    @Operation(summary = "전문가 정보 조회 API", description = "전문가의 정보를 조회합니다.")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 0이 1 페이지 이며 페이지당 4개씩 조회합니다."),
    })
    @GetMapping("/professionList")
    public ApiResponse<UserResponseDTO.ProfessionInfoListDTO> getProfessionList(@RequestParam(name = "page") Integer page) {
        Page<User> professionList = userService.getProfessionList(page);
        return ApiResponse.onSuccess(UserConverter.toProfessionInfoListDTO(professionList));
    }

}
