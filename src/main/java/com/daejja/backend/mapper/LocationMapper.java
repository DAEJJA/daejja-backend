package com.daejja.backend.mapper;

import com.daejja.backend.domain.Location;
import com.daejja.backend.domain.Schedule;
import com.daejja.backend.dto.LocationRequest;

public class LocationMapper {

    public static Location toEntity(Schedule schedule, LocationRequest request) {
        return Location.createLocation(
                request.getDay(),
                request.getName(),
                request.getAddress(),
                schedule
        );
    }
}
