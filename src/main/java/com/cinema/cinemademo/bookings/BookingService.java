package com.cinema.cinemademo.bookings;


import com.cinema.cinemademo.dto.BookingDto;
import com.cinema.cinemademo.movie.MovieService;
import com.cinema.cinemademo.showtimes.WeeklyCalendar;
import com.cinema.cinemademo.showtimes.WeeklyCalendarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

@Service
public class BookingService {

    private final WeeklyCalendarRepository weeklyCalendarRepository;
    private final BookingRepository bookingRepository;
    private final MovieService movieService;

    @Autowired
    public BookingService(WeeklyCalendarRepository weeklyCalendarRepository, BookingRepository bookingRepository, MovieService movieService) {
        this.weeklyCalendarRepository = weeklyCalendarRepository;
        this.bookingRepository = bookingRepository;
        this.movieService = movieService;
    }

    // cinema occupancy calc depending on screening time
    public double cinemaCapacity(double time) {
        double normal = 0;

        if (time == 15.00) {
            normal = 0.1;
        }
        if (time == 16.30) {
            normal = 0.2;
        }
        if (time == 18.30) {
            normal = 0.2;
        }

        if (time == 19.30) {
            normal = 0.2;
        }
        if (time == 21.00) {
            normal = 0.2;
        }
        if (time == 22.30) {
            normal = 0.2;
        }

        return normal;
    }

    // using UUID from frontend to find screening time from db
    public Double getBookingTime(UUID uuid) {

        LocalDateTime dateTime = null;
        double time;

        for (WeeklyCalendar w : weeklyCalendarRepository.findAll()) {

            if (uuid.equals(w.getId())) {
                dateTime = w.getEvent_time();

            }
        }
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("HH.mm");
        assert dateTime != null;
        String dtFormat = fm.format(dateTime);
        time = Double.parseDouble(dtFormat);

        return time;
    }
    // finding movie screening time from repository
    public LocalDateTime getMovieTime(UUID uuid) {
        LocalDateTime dateTime = null;
        for (WeeklyCalendar w : weeklyCalendarRepository.findAll()) {

            if (uuid.equals(w.getId())) {
                dateTime = w.getEvent_time();

            }
        }
        return dateTime;
    }

    public Integer getMovieId(UUID uuid) {
        int id = 0;
        for (WeeklyCalendar w : weeklyCalendarRepository.findAll()) {

            if (uuid.equals(w.getId())) {
                id = w.getMovie_id();

            }
        } return id;



    }



    // finding movie name from repository
    public String screeningMovieName(UUID uuid) {
        String movieName = null;
        for (WeeklyCalendar w : weeklyCalendarRepository.findAll()) {

            if (uuid.equals(w.getId())) {
                movieName = movieService.getMovieById(w.getMovie_id()).getMoviename();
            }

        }
        return movieName;
    }



    // calculating cinema occupancy. Taking into account screening time (later times are more occupied).
    // Also taking into account center seats which are more likely to be occupied.
    public SeatMap bookSeats(UUID uuid) {

        String movieName = screeningMovieName(uuid);
        Double time = getBookingTime(uuid);
        LocalDateTime movieTime = getMovieTime(uuid);
        List<Booking> seatList = new ArrayList<>();
        List<Integer> preciousSeats = Stream.of(44, 45, 46, 47, 53, 54, 55, 56, 57, 58, 63, 64, 65, 66, 67, 68, 73, 74, 75, 76, 77, 78, 83, 84, 85, 86, 87, 88)
                .toList();
        double normal = cinemaCapacity(time);
        double extra = 0.6 + normal;

        for (int i = 1; i <= 100; i++) {

            if (preciousSeats.contains(i)) {
                seatList.add(new Booking(i, Math.random() < extra));

            } else seatList.add(new Booking(i, Math.random() < normal));

        }
        return new SeatMap(uuid, movieTime, movieName, seatList);
    }

    // returning and saving and/or if user is present, updating booking data from frontend
    public void saveBooking(BookingDto bookingDto) {
        Integer[] seats = bookingDto.selectedSeats();
        /* right now we do not save purchased seats,
         as seatmap occupancy is generated randomly */


        String userFromDb = null;
        String movTime = String.valueOf(getBookingTime(bookingDto.uuid()));

        if(bookingDto.username() != null) {



            for (BookingUser u : bookingRepository.findAll()) {

                if (bookingDto.username().equals(u.getWho_watched())) {
                    userFromDb = u.getWho_watched();

                    bookingRepository.update(u.getId(), getMovieId(bookingDto.uuid()), bookingDto.username(), movTime);
                }

            }

            if (userFromDb == null) {
                BookingUser b = new BookingUser();
                b.setWho_watched(bookingDto.username());
                b.setLast_movie_seen(getMovieId(bookingDto.uuid()));
                b.setLast_movie_time(movTime);

                try {
                    this.bookingRepository.save(b);
                } catch (DataIntegrityViolationException e) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT);
                }
            }
        }

    }

}