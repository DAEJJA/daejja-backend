package com.daejja.backend.mapper;

import com.daejja.backend.domain.User;
import com.daejja.backend.dto.AuthSignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User toUser(AuthSignupRequest authSignupRequest) {

        String password = bCryptPasswordEncoder.encode(authSignupRequest.getPassword());

        return User.builder()
                .loginId(authSignupRequest.getLoginId())
                .password(password)
                .nickName(authSignupRequest.getNickName())
                .build();
    }
}
