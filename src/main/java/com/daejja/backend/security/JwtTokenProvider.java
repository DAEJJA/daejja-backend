package com.daejja.backend.security;

import com.daejja.backend.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.secret_refresh}")
    private String refreshSecretKey;

    // 객체 초기화, secretKey를 Base24로 인코딩
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    private String buildToken(Claims claims, Date issuedAt, Date TokenExpiresIn, String key) {

        return Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(issuedAt) // 토큰 발행 시간
                .setExpiration(TokenExpiresIn) // set Expire Time
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    // accessToken 생성
    public String generateAccessToken(User user) {

        Claims claims = Jwts.claims().setSubject(user.getLoginId());
        Date issuedAt = new Date();
        Date tokenExpiresIn = new Date(issuedAt.getTime() + JwtProperties.ACCESS_TOKEN_EXPIRATION_TIME);

        return buildToken(claims, issuedAt, tokenExpiresIn, secretKey);
    }

    // refreshToken 생성
    public String generateRefreshToken(User user) {

        Claims claims = Jwts.claims().setSubject(user.getLoginId());
        Date issuedAt = new Date();
        Date TokenExpiresIn = new Date(issuedAt.getTime() + JwtProperties.REFRESH_TOKEN_EXPIRATION_TIME);

        return buildToken(claims, issuedAt, TokenExpiresIn, refreshSecretKey);
    }

    // accessToken에서 loginId 추출
    public String getLoginIdFromAccessToken(String token) {

        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
}
