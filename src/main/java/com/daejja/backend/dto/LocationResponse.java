package com.daejja.backend.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LocationResponse {

    private Long locationId;
    private String day;
    private String name;
    private String address;
}
