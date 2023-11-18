package com.daejja.backend.controller;

import com.daejja.backend.dto.ScheduleCreateRequest;
import com.daejja.backend.security.auth.AuthDetails;
import com.daejja.backend.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("")
    public ResponseEntity<Void> saveSchedule(
            @RequestBody ScheduleCreateRequest request,
            @AuthenticationPrincipal AuthDetails authDetails) {

        Long userId = authDetails.getUser().getId();
        scheduleService.saveSchedule(request, userId);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
