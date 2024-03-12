package com.cinema.cinemademo.bookings;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;



public interface BookingRepository extends JpaRepository<BookingUser, Integer> {


    @Transactional
    @Modifying
    @Query("UPDATE bookinguser SET last_movie_seen = ?2, who_watched = ?3, last_movie_time = ?4 WHERE id = ?1 ")
    void update (Integer id, Integer last_movie_seen, String who_watched, String last_movie_time);


}
