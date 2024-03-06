package com.cinema.cinemademo.movie;

import jakarta.persistence.*;

@Entity(name = "genre")
public class Genre {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer movie_id;
    @Column
    private String genre;


    public Integer getMovie_id() {
        return movie_id;
    }

    public String getGenre() {
        return genre;
    }
}
