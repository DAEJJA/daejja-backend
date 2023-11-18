package com.daejja.backend.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    private String name;
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Builder
    public Location(String name, String address, Schedule schedule) {
        this.name = name;
        this.address = address;
        this.schedule = schedule;
    }

    public static Location createLocation(String name, String address, Schedule schedule) {
        return Location.builder()
                .name(name)
                .address(address)
                .schedule(schedule)
                .build();
    }
}
