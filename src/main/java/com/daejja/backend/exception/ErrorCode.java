package com.daejja.backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 공통 에러
    BAD_REQUEST_PARAM(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),

    // USER 에러
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "해당 유저를 찾을 수 없습니다."),
    UNAUTHORIZED_ID(HttpStatus.UNAUTHORIZED, "아이디가 틀립니다."),
    UNAUTHORIZED_PASSWORD(HttpStatus.UNAUTHORIZED, "비밀번호가 틀립니다."),

    // SCHEDULE 에러
    NOT_FOUND_SCHEDULE(HttpStatus.NOT_FOUND, "해당 일정을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String error;
}
