package com.daejja.backend.repository;

import com.daejja.backend.domain.Schedule;
import com.daejja.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByUser(User user);
}
