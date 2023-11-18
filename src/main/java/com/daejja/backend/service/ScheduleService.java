package com.daejja.backend.service;

import com.daejja.backend.domain.Location;
import com.daejja.backend.domain.Schedule;
import com.daejja.backend.domain.User;
import com.daejja.backend.dto.LocationCreateRequest;
import com.daejja.backend.dto.ScheduleCreateRequest;
import com.daejja.backend.dto.ScheduleFindAllResponse;
import com.daejja.backend.exception.CustomException;
import com.daejja.backend.exception.ErrorCode;
import com.daejja.backend.mapper.LocationMapper;
import com.daejja.backend.mapper.ScheduleMapper;
import com.daejja.backend.repository.LocationRepository;
import com.daejja.backend.repository.ScheduleRepository;
import com.daejja.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;
    private final LocationRepository locationRepository;

    /**
     * 일정 저장
     */
    public void saveSchedule(ScheduleCreateRequest request, Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));

        Schedule schedule = ScheduleMapper.toEntity(user, request);

        scheduleRepository.save(schedule);

        for (LocationCreateRequest locationCreateRequest : request.getLocations()) {
            Location location = LocationMapper.toEntity(schedule, locationCreateRequest);

            locationRepository.save(location);
        }
    }

    /**
     * 일정 목록 조회
     */
    public List<ScheduleFindAllResponse> findAllSchedule(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));

        List<Schedule> results = scheduleRepository.findByUser(user);

        return results.stream()
                .map(ScheduleMapper::toScheduleFindAllResponse)
                .toList();
    }
}
