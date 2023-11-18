package com.daejja.backend.mapper;

import com.daejja.backend.domain.Location;
import com.daejja.backend.domain.Schedule;
import com.daejja.backend.dto.LocationRequest;
import com.daejja.backend.dto.LocationResponse;
import com.daejja.backend.dto.ScheduleFindAllResponse;

public class LocationMapper {

    public static Location toEntity(Schedule schedule, LocationRequest request) {
        return Location.createLocation(
                request.getDay(),
                request.getName(),
                request.getAddress(),
                schedule
        );
    }

    public static LocationResponse toLocationFindAllResponse(Location location) {
        return LocationResponse.builder()
                .locationId(location.getId())
                .day(location.getDay())
                .name(location.getName())
                .address(location.getAddress())
                .build();
    }
}
