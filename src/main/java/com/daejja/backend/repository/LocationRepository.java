package com.daejja.backend.repository;

import com.daejja.backend.domain.Location;
import com.daejja.backend.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findBySchedule(Schedule schedule);
}
