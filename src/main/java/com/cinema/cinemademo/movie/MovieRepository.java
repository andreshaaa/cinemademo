package com.cinema.cinemademo.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
//List<Movie> findAllByIdIn(List<Integer> ids);
//List<Movie> findAllByOrderByIdAsc();

 //   @Query("SELECT * FROM movie ")
  //  List<Movie> findAllMoviesByGenre(String genre);

}
