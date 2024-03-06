package com.cinema.cinemademo;

import com.cinema.cinemademo.bookings.Booking;
import com.cinema.cinemademo.bookings.BookingService;
import com.cinema.cinemademo.movie.DailyEvent;
import com.cinema.cinemademo.movie.Movie;
import com.cinema.cinemademo.movie.MovieService;

import com.cinema.cinemademo.showtimes.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/cinema")
@CrossOrigin
public class CinemaController {

    private final MovieService movieService;
    private final ShowtimeService showtimeService;
    private final BookingService bookingService;

    @Autowired
    public CinemaController(MovieService movieService, ShowtimeService showtimeService, BookingService bookingService) {
        this.movieService = movieService;
        this.showtimeService = showtimeService;
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {return this.movieService.getAllMovies();}

    @GetMapping("/genre/{genre}")
    public List<Optional<Movie>> getMovieByGenre(@PathVariable("genre") String genre) {
       return this.movieService.getMovieByGenre(genre);
    }

    @GetMapping("/language/{language}")
    public List<Movie> getMovieByLanguage(@PathVariable("language") String language) {
        return this.movieService.getMovieByLanguage(language);
    }
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") Integer id) {
        return this.movieService.getMovieById(id);
    }
    @GetMapping("/showtime/{selectDay}")
    public List<DailyEvent> getMovieByWeekday(@PathVariable("selectDay") Integer id) {
        return this.showtimeService.getMovieByWeekday(id);

    }
    /*
    @GetMapping("/daily/{selectDay}")
    public Map<Integer, List<Optional<Movie>>> getDailyMovies(@PathVariable("selectDay") Integer id) {
        return this.showtimeService.getDailyMovies(id); }*/
    /*
    @GetMapping("/dailytimes")
    public StartTime getDailyTimes(){
        return this.showtimeService.getDailyTimes();
    } */

    // remove to bookingservice service and need  (c)Booking
    @GetMapping("/bookseats/{time}")
    public List<Booking> bookSeats(@PathVariable("time") Double num ){
        return this.bookingService.bookSeats(num);
    }


}
