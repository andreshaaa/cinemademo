package com.cinema.cinemademo.movie;

import com.cinema.cinemademo.showtimes.Showtime;
import com.cinema.cinemademo.showtimes.ShowtimeRepository;
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
private final ShowtimeRepository showtimeRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository,GenreRepository genreRepository, ShowtimeRepository showtimeRepository) {

        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.showtimeRepository = showtimeRepository;
    }

    public List<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }

    public Movie getMovieById(Integer id) {
        Optional <Movie> movie = this.movieRepository.findById(id);

        if (movie.isPresent()) {
            return movie.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }



    public List<Optional<Movie>> getMovieByGenre(String genre) {
      String searchWord = genre;
      List <Genre> genreList = this.genreRepository.findAll();
      List<Optional<Movie>> returnMovies = new ArrayList<>();
      for (Genre searchGenre : genreList) {
          if (searchGenre.getGenre().equals(searchWord)){
             returnMovies.add(this.movieRepository.findById(searchGenre.getMovie_id()));

          }

      }
      if (returnMovies.isEmpty()){
          throw new ResponseStatusException(HttpStatus.NOT_FOUND);}


    return returnMovies;
    }

    public List<Movie> getMovieByLanguage(String language) {
        String searchWord = language;
        List <Movie> movieList = this.movieRepository.findAll();
        List <Movie> returnList = new ArrayList<>();
        for (Movie movie : movieList) {
            if (movie.getLanguage().equals(searchWord)) {
                returnList.add(movie);
            }
        }
        if (returnList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);}


        return returnList;
    }
    // HELP
    public void getDailyEvents (Integer id) {

        int searchDay = id;






    }

}
