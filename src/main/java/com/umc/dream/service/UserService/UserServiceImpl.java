package com.umc.dream.service.UserService;

import com.umc.dream.apiPayload.code.status.ErrorStatus;
import com.umc.dream.apiPayload.exception.GeneralException;
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

    @Override
    public User login(UserRequestDTO.LoginDto request) {
        String userAccount = request.getAccount();
        String userPassword = request.getPassword();

        User user = userRepository.findByAccount(request.getAccount())
                .orElseThrow(() -> new GeneralException(ErrorStatus._BAD_REQUEST));

        if (user.getAccount().equals(userAccount) && user.getPassword().equals(userPassword)) {
            return user;
        }
        else {
            throw new GeneralException(ErrorStatus._BAD_REQUEST);
        }
    }

}
