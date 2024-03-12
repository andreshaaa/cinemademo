package com.cinema.cinemademo.movie;

import com.cinema.cinemademo.bookings.BookingRepository;
import com.cinema.cinemademo.bookings.BookingUser;
import com.cinema.cinemademo.showtimes.WeeklyCalendar;
import com.cinema.cinemademo.showtimes.WeeklyCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final BookingRepository bookingRepository;
    private final WeeklyCalendarRepository weeklyCalendarRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, GenreRepository genreRepository,  BookingRepository bookingRepository, WeeklyCalendarRepository weeklyCalendarRepository) {

        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.bookingRepository = bookingRepository;
        this.weeklyCalendarRepository = weeklyCalendarRepository;
    }

    // finding a movie from movie repository

    public Movie getMovieById(Integer id) {
        Optional<Movie> movie = this.movieRepository.findById(id);

        if (movie.isPresent()) {
            return movie.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    //
    public List <String> getGenreByMovieId(Integer movieId) {

        List<Genre> genreList = genreRepository.findAll();
        List<String> genres = new ArrayList<>();
        String temp1 = null;
        String temp2 = null;
        String temp3 = null;
        String temp4 = null;
        String temp5 = null;

        for (Genre gen : genreList) {
            if (gen.getMovie_id().equals(movieId)) {
                if (temp1 == null) {
                    temp1 = gen.getGenre();
                } else if (temp2 == null) {
                    temp2 = gen.getGenre();
                } else if (temp3 == null) {
                    temp3 = gen.getGenre();
                } else if (temp4 == null) {
                    temp4 = gen.getGenre();
                } else if (temp5 == null) {
                    temp5 = gen.getGenre();
                }
            }
        }
        genres.add(temp1);
        if (temp2!=null){
            genres.add(temp2);
        }
        if (temp3!=null){
            genres.add(temp3);
        }
        if (temp4!=null){
            genres.add(temp4);
        }
        if (temp5!=null) {
            genres.add(temp5);
        }

        return genres;
    }
    // filtering weekly movie list through selected language filter
    public List <DailyEvent> weeklyByLanguage (List<DailyEvent> searchList, String selectedLanguage) {


        List <DailyEvent> listToSend = new ArrayList<>();

            for (DailyEvent d : searchList) {
                if (getMovieById(d.getMovie_id()).getLanguage().equals(selectedLanguage)) {
                    listToSend.add(d);

                }
            }  return listToSend;
    }
    // collecting all movies from the weekly movie repository
    public List <DailyEvent> allWeek () {
        List <WeeklyCalendar> allEvents = weeklyCalendarRepository.findAll();
        List <DailyEvent> returnList = new ArrayList<>();
        for (WeeklyCalendar tempCalendar : allEvents) {

            returnList.add(new DailyEvent(tempCalendar.getId(),
                        tempCalendar.getEvent_time(),
                        tempCalendar.getMovie_id(),
                        getMovieById(tempCalendar.getMovie_id()).getMoviename(),
                        getMovieById(tempCalendar.getMovie_id()).getAgelimit(),
                        getMovieById(tempCalendar.getMovie_id()).getDuration(),
                    getMovieById(tempCalendar.getMovie_id()).getLanguage(),
                    getGenreByMovieId(tempCalendar.getMovie_id())));
            }

        return returnList;
    }


    // compiling the weekly movie list. Depending on filters.
    public List <DailyEvent> weeklyCalendar (String language, String genre, String userName, String rating, String time) {


        String all = "all-movies";

        List<DailyEvent> returnList = allWeek();

        if(!language.equals(all)) {
            returnList = weeklyByLanguage(returnList, language);
        }

        if(!time.equals(all)) {

            returnList = weeklyByDay(returnList, time);
        }

        if(!genre.equals(all)) {

            returnList = weekByGenre(returnList, genre);}

        if(!rating.equals(all)) {

            returnList = weekByRating(returnList, rating);}

        if(!userName.equals(all)) {
           if(isUserPresent(userName)) {
               returnList = recommendMovies(returnList, userName);
           }
        }

        if (genre.equals(all) && language.equals(all) && time.equals(all) && rating.equals(all) && userName.equals(all)) {

            return allWeek();
        }

        return returnList;
    // checking if user is present for the recommendation.
    }
    private Boolean isUserPresent (String user) {

       List<BookingUser> b = bookingRepository.findAll();

        for (BookingUser c : b) {
            if (c.getWho_watched().equals(user)) {
                return true;
            }

        } return false;
    }
    // // filtering weekly movie list through selected age rating filter
    private List<DailyEvent> weekByRating(List<DailyEvent> searchList, String selectedPrefs) {

        String u = "U";
        String twelwe = "12";
        String fifteen = "15";

        String filter1 = u;
        String filter2 = u;

        if(selectedPrefs.equals(u)) { filter1 = u; filter2 = u;}
        if(selectedPrefs.equals(twelwe)) {filter1 = u; filter2 = selectedPrefs;}
        if(selectedPrefs.equals(fifteen)) {filter1 = u; filter2 = twelwe;}


        List <DailyEvent> listToSend = new ArrayList<>();

        for (DailyEvent d : searchList) {
            if (getMovieById(d.getMovie_id()).getAgelimit().equals(selectedPrefs)||
                    getMovieById(d.getMovie_id()).getAgelimit().equals(filter1)||
            getMovieById(d.getMovie_id()).getAgelimit().equals(filter2))
            {
                listToSend.add(d);
            }
        }

        return listToSend;
    }
    // filtering weekly movie list through selected start time filter

    public List <DailyEvent> weeklyByDay (List<DailyEvent> searchList, String searchWord) {

        List <DailyEvent> listToSend = new ArrayList<>();

        for (DailyEvent d : searchList) {
            if (d.getEvent_time().getHour()==Integer.parseInt(searchWord.substring(0,2))
            && d.getEvent_time().getMinute()==Integer.parseInt(searchWord.substring(3,5))){
                listToSend.add(d);
            }
        }
        return listToSend;
    }

    // filtering weekly movie list through selected genre filter
    public List <DailyEvent> weekByGenre (List<DailyEvent> searchList, String searchWord) {

        List <DailyEvent> listToSend = new ArrayList<>();

        for (DailyEvent d : searchList) {

            if (getGenreByMovieId(d.getMovie_id()).contains(searchWord)){
                listToSend.add(d);
            }
        }


        return listToSend;
    }
    // Recommending movies. Is user has watched any movies previously,
    // recommending movies based on genre and start time of the last movie user watched.
    public List<DailyEvent> recommendMovies (List<DailyEvent> searchList, String user) {

        List <DailyEvent> listToSend = new ArrayList<>();

        List<BookingUser> l =  bookingRepository.findAll();

        int movSeen = 0;
        String movTime = null;

        for(BookingUser b : l) {

            if (b.getWho_watched().equals(user)) {
                movSeen = b.getLast_movie_seen();
                movTime = b.getLast_movie_time();
            }
        }

       List <String> genre = getGenreByMovieId(movSeen);

        for (DailyEvent d : searchList) {
            if(movSeen==0) { return allWeek();}
            if (getGenreByMovieId(d.getMovie_id()).contains(genre.getFirst())){
                listToSend.add(d);}

        }

       listToSend = weeklyByDay(listToSend, movTime+0);
        return listToSend;

    }

}
