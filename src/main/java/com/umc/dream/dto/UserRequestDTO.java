package com.umc.dream.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class UserRequestDTO {

    @Getter
    public static class JoinDto {
        @NotBlank
        String name;
        @NotNull
        String account;
        @NotNull
        String password;
    }

    @Getter
    public static class LoginDto {
        @NotNull
        String account;
        @NotNull
        String password;
    }

    @Getter
    public static class CheckAccountRequestDto {
        @NotNull
        String account;
    }
}
