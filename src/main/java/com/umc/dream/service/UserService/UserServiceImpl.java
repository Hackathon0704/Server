package com.umc.dream.service.UserService;

import com.umc.dream.converter.UserConverter;
import com.umc.dream.domain.User;
import com.umc.dream.dto.UserRequestDTO;
import com.umc.dream.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User join(UserRequestDTO.JoinDto request) {
        User user = UserConverter.toUser(request);
        return userRepository.save(user);
    }

}
