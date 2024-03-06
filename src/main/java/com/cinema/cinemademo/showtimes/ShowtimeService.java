package com.cinema.cinemademo.showtimes;

import com.cinema.cinemademo.movie.DailyEvent;
import com.cinema.cinemademo.movie.Movie;
import com.cinema.cinemademo.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public ShowtimeService(ShowtimeRepository showtimeRepository, MovieRepository movieRepository) {
        this.showtimeRepository = showtimeRepository;
        this.movieRepository = movieRepository;
    }

    // get movie by weekday
    public List<DailyEvent> getMovieByWeekday(Integer id) {

        List <Showtime> list = showtimeRepository.findAll();
        // optional!
        List <Optional<Movie>> exit = new ArrayList<>();
        List <DailyEvent> daily = new ArrayList<>();
        List<String> startTimes = new ArrayList<>();
        startTimes.add("15:00");
        startTimes.add("16:30");
        startTimes.add("18:00");
        startTimes.add("19:30");
        startTimes.add("21:00");
        startTimes.add("22:30");
        int i = -1;

        for (Showtime time : list) {
            if (time.getId().equals(id)){


                exit.add(movieRepository.findById(time.getStart_15_00()));
                exit.add(movieRepository.findById(time.getStart_16_30()));
                exit.add(movieRepository.findById(time.getStart_18_00()));
                exit.add(movieRepository.findById(time.getStart_19_30()));
                exit.add(movieRepository.findById(time.getStart_21_00()));
                exit.add(movieRepository.findById(time.getStart_22_30()));
            }
        }
        for (Optional<Movie> mov : exit) {

            i++;

            if(mov.isPresent()){
                Movie a = mov.get();
                daily.add(new DailyEvent(
                        a.getId(),
                        a.getMoviename(),
                        a.getAgelimit(),
                        a.getDuration(),
                        a.getLanguage(),
                        startTimes.get(i)));
            } else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }





        return daily;
    }











}
