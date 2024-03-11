package com.cinema.cinemademo.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DailyEvent {


    private UUID id;

    private LocalDateTime event_time;

    private Integer movie_id;

    private String movieName;

    private String movieAgeLimit;

    private String duration;

    private String language;

    private List<String> genre;
}
