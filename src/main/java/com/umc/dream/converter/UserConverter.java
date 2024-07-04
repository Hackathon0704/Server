package com.umc.dream.converter;

import com.umc.dream.domain.User;
import com.umc.dream.domain.enums.Role;
import com.umc.dream.dto.UserRequestDTO;
import com.umc.dream.dto.UserResponseDTO;

import java.time.LocalDateTime;

public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static UserResponseDTO.LoginResultDTO toLoginResultDTO(User user) {
        return UserResponseDTO.LoginResultDTO.builder()
                .userId(user.getId())
                .name(user.getName())
                .build();
    }

    public static UserResponseDTO.CheckAccountResultDTO toCheckAccountResultDTO(boolean isDuplicated) {
        return new UserResponseDTO.CheckAccountResultDTO(isDuplicated);
    }

    public static User toUser(UserRequestDTO.JoinDto joinDto) {
        return User.builder()
                .name(joinDto.getName())
                .account(joinDto.getAccount())
                .password(joinDto.getPassword())
                .role(Role.NORMAL)
                .build();
    }

}
