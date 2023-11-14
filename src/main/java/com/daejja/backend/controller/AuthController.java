package com.daejja.backend.controller;

import com.daejja.backend.dto.AuthLoginRequest;
import com.daejja.backend.dto.AuthLoginResponse;
import com.daejja.backend.dto.AuthSignupRequest;
import com.daejja.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * 유저 회원가입
     */
    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody AuthSignupRequest authSignupRequest) {
        authService.signUp(authSignupRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 유저 로그인
     */
    @GetMapping("/login")
    public ResponseEntity<AuthLoginResponse> login(@RequestBody AuthLoginRequest authLoginRequest) {
        AuthLoginResponse authLoginResponse = authService.login(authLoginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(authLoginResponse);
    }

}
