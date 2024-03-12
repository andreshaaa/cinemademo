package com.cinema.cinemademo;
import com.cinema.cinemademo.bookings.BookingService;
import com.cinema.cinemademo.bookings.SeatMap;
import com.cinema.cinemademo.dto.BookingDto;
import com.cinema.cinemademo.movie.DailyEvent;
import com.cinema.cinemademo.movie.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cinema")
@CrossOrigin
public class CinemaController {

    private final MovieService movieService;

    private final BookingService bookingService;


    @Autowired
    public CinemaController(MovieService movieService, BookingService bookingService) {
        this.movieService = movieService;
        this.bookingService = bookingService;
    }


    @GetMapping("/weeklycalendar/")
    public List<DailyEvent> getMovieByWeekday(@RequestParam(name="language", required = false, defaultValue="all-movies") String language,
                                              @RequestParam(name="genre", required = false, defaultValue="all-movies") String genre,
                                              @RequestParam(name="userName", required = false, defaultValue="all-movies") String userName,
                                              @RequestParam(name="rating", required = false, defaultValue="all-movies") String rating,
                                              @RequestParam(name="time", required = false, defaultValue="all-movies") String time)


    {return this.movieService.weeklyCalendar(language, genre, userName, rating, time);}

    @PostMapping("/bookingresponse")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveBooking(@Valid @RequestBody BookingDto bookingDto) {
        this.bookingService.saveBooking(bookingDto);
    }

    // seatmap endpoint
    @GetMapping("/bookseats/{time}")
    public SeatMap bookSeats(@PathVariable("time") UUID num ){
        return this.bookingService.bookSeats(num);
    }


}
