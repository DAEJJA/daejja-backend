package com.daejja.backend.mapper;

import com.daejja.backend.domain.Location;
import com.daejja.backend.domain.Schedule;
import com.daejja.backend.domain.User;
import com.daejja.backend.dto.LocationResponse;
import com.daejja.backend.dto.ScheduleCreateRequest;
import com.daejja.backend.dto.ScheduleFindAllResponse;
import com.daejja.backend.dto.ScheduleFindOneResponse;

import java.util.List;

public class ScheduleMapper {

    public static Schedule toEntity(User user, ScheduleCreateRequest request) {
        return Schedule.createSchedule(
                request.getTitle(),
                request.getDescription(),
                user
        );
    }

    public static ScheduleFindAllResponse toScheduleFindAllResponse(Schedule schedule) {
        return ScheduleFindAllResponse.builder()
                .scheduleId(schedule.getId())
                .title(schedule.getTitle())
                .description(schedule.getDescription())
                .build();
    }

    public static ScheduleFindOneResponse toScheduleFindOneResponse(Schedule schedule, List<LocationResponse> results) {
        return ScheduleFindOneResponse.builder()
                .title(schedule.getTitle())
                .description(schedule.getDescription())
                .locations(results)
                .build();
    }


}
