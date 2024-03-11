package com.cinema.cinemademo.showtimes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeeklyCalendarRepository extends JpaRepository<WeeklyCalendar, Integer> {
}
