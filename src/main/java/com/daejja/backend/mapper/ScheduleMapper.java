package com.daejja.backend.mapper;

import com.daejja.backend.domain.Schedule;
import com.daejja.backend.domain.User;
import com.daejja.backend.dto.ScheduleCreateRequest;

public class ScheduleMapper {

    public static Schedule toEntity(User user, ScheduleCreateRequest request) {
        return Schedule.createSchedule(
                request.getTitle(),
                request.getDescription(),
                user
        );
    }

}
