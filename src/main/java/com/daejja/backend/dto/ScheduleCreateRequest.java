package com.daejja.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ScheduleCreateRequest {

    private String title;
    private String description;
    private List<LocationRequest> locations;
}
