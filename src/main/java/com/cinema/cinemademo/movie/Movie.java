package com.cinema.cinemademo.movie;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "movie")
public class Movie {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String moviename;
    @Column
    private String agelimit;
    @Column
    private String duration;
    @Column
    private String language;



   // public String getMoviename() {return moviename;}

   // public String getAgelimit() {return agelimit;}

   // public String getDuration() {return duration;}

   // public String getLanguage() {return language;}
}
