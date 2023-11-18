package com.daejja.backend.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    private String title;
    private String description;

    @Builder
    public Schedule(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public static Schedule createSchedule(String title, String description) {
        return Schedule.builder()
                .title(title)
                .description(description)
                .build();
    }

}
