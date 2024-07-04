package com.umc.dream.service.UserService;

import com.umc.dream.domain.User;
import com.umc.dream.dto.UserRequestDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    User join(UserRequestDTO.JoinDto request);

    User login(UserRequestDTO.LoginDto request);

    boolean CheckAccount(UserRequestDTO.CheckAccountRequestDto request);
    Page<User> getProfessionList(Integer page);
}
