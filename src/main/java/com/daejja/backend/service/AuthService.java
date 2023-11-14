package com.daejja.backend.service;

import com.daejja.backend.domain.User;
import com.daejja.backend.dto.AuthLoginRequest;
import com.daejja.backend.dto.AuthLoginResponse;
import com.daejja.backend.dto.AuthSignupRequest;
import com.daejja.backend.exception.CustomException;
import com.daejja.backend.exception.ErrorCode;
import com.daejja.backend.mapper.UserMapper;
import com.daejja.backend.repository.UserRepository;
import com.daejja.backend.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.JstlUtils;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final TokenPairService tokenPairService;

    /**
     * 유저 회원가입
     */
    public void signUp(AuthSignupRequest authSignupRequest) {

        User user = userMapper.toUser(authSignupRequest);
        userRepository.save(user);
    }

    /**
     * 유저 로그인
     */
    public AuthLoginResponse login(AuthLoginRequest authLoginRequest) {

        User user = userRepository.findByLoginId(authLoginRequest.getLoginId());

        if(user == null) {
            throw new CustomException(ErrorCode.UNAUTHORIZED_ID);
        }
        if(!passwordEncoder.matches(authLoginRequest.getPassword(), user.getPassword())) {
            throw new CustomException(ErrorCode.UNAUTHORIZED_PASSWORD);
        }

        // 토큰 생성
        String accessToken = jwtTokenProvider.generateAccessToken(user);
        String refreshToken = jwtTokenProvider.generateRefreshToken(user);
        tokenPairService.saveTokenPair(accessToken, refreshToken, user);

        AuthLoginResponse authLoginResponse = AuthLoginResponse.builder()
                .userId(user.getId())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

        return authLoginResponse;
    }
}
