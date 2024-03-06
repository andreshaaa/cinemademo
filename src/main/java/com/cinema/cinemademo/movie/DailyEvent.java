package com.cinema.cinemademo.movie;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DailyEvent {



    private Integer dailyId;

    private String dailyMovieName;

    private String dailyAgeLimit;

    private String dailyDuration;

    private String dailyLanguage;

    private String dailyStartTime;
}
