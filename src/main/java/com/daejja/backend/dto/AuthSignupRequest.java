package com.daejja.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AuthSignupRequest {

    private String loginId;
    private String password;
    private String nickName;

}
