package com.daejja.backend.mapper;

import com.daejja.backend.domain.Location;
import com.daejja.backend.domain.Schedule;
import com.daejja.backend.dto.LocationCreateRequest;

public class LocationMapper {

    public static Location toEntity(Schedule schedule, LocationCreateRequest request) {
        return Location.createLocation(
                request.getDay(),
                request.getName(),
                request.getAddress(),
                schedule
        );
    }
}
