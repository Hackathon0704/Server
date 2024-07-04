package com.umc.dream.converter;

import com.umc.dream.domain.User;
import com.umc.dream.domain.enums.Role;
import com.umc.dream.dto.UserRequestDTO;
import com.umc.dream.dto.UserResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static UserResponseDTO.ProfessionInfoListDTO toProfessionInfoListDTO(Page<User> professionInfoList) {
        List<UserResponseDTO.ProfessionInfoDTO> professionInfoDTOList = professionInfoList.stream()
                .map(UserConverter::toProfessionInfoDTO)
                .collect(Collectors.toList());

        return UserResponseDTO.ProfessionInfoListDTO.builder()
                .isLast(professionInfoList.isLast())
                .isFirst(professionInfoList.isFirst())
                .totalPage(professionInfoList.getTotalPages())
                .totalElements(professionInfoList.getTotalElements())
                .listSize(professionInfoDTOList.size())
                .professionInfoDTOList(professionInfoDTOList)
                .build();

    }

    public static UserResponseDTO.ProfessionInfoDTO toProfessionInfoDTO(User user) {
        return UserResponseDTO.ProfessionInfoDTO.builder()
                .name(user.getName())
                .job(user.getJob())
                .description(user.getDescription())
                .price(user.getPrice())
                .build();
    }

}
