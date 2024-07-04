package com.umc.dream.service.UserService;

import com.umc.dream.domain.User;
import com.umc.dream.dto.UserRequestDTO;

public interface UserService {
    User join(UserRequestDTO.JoinDto request);

    User login(UserRequestDTO.LoginDto request);

    boolean CheckAccount(UserRequestDTO.CheckAccountRequestDto request);
}
