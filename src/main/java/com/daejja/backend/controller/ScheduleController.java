package com.daejja.backend.controller;

import com.daejja.backend.dto.ScheduleCreateRequest;
import com.daejja.backend.dto.ScheduleFindAllResponse;
import com.daejja.backend.dto.ScheduleFindOneResponse;
import com.daejja.backend.security.auth.AuthDetails;
import com.daejja.backend.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    /**
     * 일정 정보 저장
     */
    @PostMapping("")
    public ResponseEntity<Void> saveSchedule(
            @RequestBody ScheduleCreateRequest request,
            @AuthenticationPrincipal AuthDetails authDetails) {

        Long userId = authDetails.getUser().getId();
        scheduleService.saveSchedule(request, userId);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 일정 목록 조회
     */
    @GetMapping("")
    public ResponseEntity<List<ScheduleFindAllResponse>> findAllSchedule(
            @AuthenticationPrincipal AuthDetails authDetails) {

        Long userId = authDetails.getUser().getId();

        List<ScheduleFindAllResponse> response = scheduleService.findAllSchedule(userId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * 일정 상세 조회
     */
    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleFindOneResponse> findOneSchedule(@PathVariable Long scheduleId) {

        ScheduleFindOneResponse response = scheduleService.findOneSchedule(scheduleId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
