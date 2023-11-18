package com.daejja.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LocationCreateRequest {

    private String day;
    private String name;
    private String address;
}
