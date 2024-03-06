package com.cinema.cinemademo.bookings;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookingService {


    @Autowired
    public BookingService(){}

    public List<Booking> bookSeats(double time) {
        List<Booking> seatList = new ArrayList<>();

        seatList.add(new Booking("seat1","vacant"));
        seatList.add(new Booking("seat2","vacant"));
        seatList.add(new Booking("seat3","vacant"));
        seatList.add(new Booking("seat4","vacant"));
        seatList.add(new Booking("seat5","vacant"));
        seatList.add(new Booking("seat6","vacant"));
        seatList.add(new Booking("seat7","vacant"));
        seatList.add(new Booking("seat8","vacant"));
        seatList.add(new Booking("seat9","vacant"));
        seatList.add(new Booking("seat10","vacant"));


        return seatList;
    }
}
