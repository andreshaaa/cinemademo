package com.cinema.cinemademo.bookings;

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
public class SeatMap {

        private UUID id;

        private LocalDateTime startTime;

        private String movieName;

        private List<Booking> seats;



}

