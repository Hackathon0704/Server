package com.umc.dream.service.UserService;

import com.umc.dream.apiPayload.code.status.ErrorStatus;
import com.umc.dream.apiPayload.exception.GeneralException;
import com.umc.dream.converter.UserConverter;
import com.umc.dream.domain.User;
import com.umc.dream.domain.enums.Role;
import com.umc.dream.dto.UserRequestDTO;
import com.umc.dream.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public boolean CheckAccount(UserRequestDTO.CheckAccountRequestDto request) {
        Optional<User> user = userRepository.findByAccount(request.getAccount());

        if (user.isPresent()) {    // 아이디 중복
            return true;
        } else {  // 아이디 중복x
            return false;
        }
    }

    @Override
    public Page<User> getProfessionList(Integer page) {
        Page<User> professionList = userRepository.findByRole(Role.PRO, PageRequest.of(page, 4));
        return professionList;
    }
}
