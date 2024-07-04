package com.umc.dream.controller;

import com.umc.dream.apiPayload.ApiResponse;
import com.umc.dream.domain.User;
import com.umc.dream.dto.UserRequestDTO;
import com.umc.dream.dto.UserResponseDTO;
import com.umc.dream.service.UserService.UserService;
import com.umc.dream.converter.UserConverter;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
