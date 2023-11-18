package com.daejja.backend.mapper;

import com.daejja.backend.domain.Schedule;
import com.daejja.backend.domain.User;
import com.daejja.backend.dto.ScheduleCreateRequest;
import com.daejja.backend.dto.ScheduleFindAllResponse;

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

}
