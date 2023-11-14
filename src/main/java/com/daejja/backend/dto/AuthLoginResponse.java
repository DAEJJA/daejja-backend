package com.daejja.backend.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AuthLoginResponse {

    private Long userId;
    private String accessToken;
    private String refreshToken;
}
