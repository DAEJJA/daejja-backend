package com.daejja.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AuthLoginRequest {

    private String loginId;
    private String password;
}
