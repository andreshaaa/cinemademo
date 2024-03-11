package com.cinema.cinemademo.showtimes;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "weeklycalendar")
public class WeeklyCalendar {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id  = UUID.randomUUID();
    @Column
    private LocalDateTime event_time;
    @Column
    private Integer movie_id;


}
