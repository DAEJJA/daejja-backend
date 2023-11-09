package com.daejja.backend.service;

import com.daejja.backend.domain.User;
import com.daejja.backend.dto.AuthSignupRequest;
import com.daejja.backend.mapper.UserMapper;
import com.daejja.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    /**
     * 유저 회원가입
     */
    public void signUp(AuthSignupRequest authSignupRequest) {
        User user = userMapper.toUser(authSignupRequest);
        userRepository.save(user);
    }
}
