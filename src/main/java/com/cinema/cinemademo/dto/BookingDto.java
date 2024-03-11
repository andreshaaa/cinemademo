package com.cinema.cinemademo.dto;

import java.util.UUID;

public record BookingDto(

        UUID uuid,
        Integer[] selectedSeat,
        String mName,
        String username
) {
}
