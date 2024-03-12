package com.cinema.cinemademo.movie;

import jakarta.persistence.*;
import lombok.Getter;

@Entity(name = "genre")
public class Genre {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Column
    private Integer movie_id;
    @Getter
    @Column
    private String genre;


}
