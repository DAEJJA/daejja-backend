package com.daejja.backend.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ScheduleFindOneResponse {

    private String title;
    private String description;
    private List<LocationResponse> locations;
}
