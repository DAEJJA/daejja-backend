package com.daejja.backend.service;

import com.daejja.backend.domain.TokenPair;
import com.daejja.backend.domain.User;
import com.daejja.backend.repository.TokenPairRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TokenPairService {

    private final TokenPairRepository tokenPairRepository;

    public void saveTokenPair(String accessToken, String refreshToken, User user) {

        TokenPair tokenPair = TokenPair.createTokenPair(accessToken, refreshToken, user);

        // 기존 토큰이 있으면 업데이트하고, 없으면 새로 생성하여 저장
        tokenPairRepository.findByUser(user)
                .ifPresentOrElse(
                        (findTokenPair) -> findTokenPair.updateToken(accessToken, refreshToken),
                        () -> tokenPairRepository.save(tokenPair)
                );
    }

}
