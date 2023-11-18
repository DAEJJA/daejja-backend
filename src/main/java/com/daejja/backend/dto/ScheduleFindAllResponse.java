package com.daejja.backend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ScheduleFindAllResponse {

    private Long scheduleId;
    private String title;
    private String description;
}
