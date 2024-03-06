package com.cinema.cinemademo.showtimes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "showtime")
public class Showtime {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer start_15_00;
    @Column
    private Integer start_16_30;
    @Column
    private Integer start_18_00;
    @Column
    private Integer start_19_30;
    @Column
    private Integer start_21_00;
    @Column
    private Integer start_22_30;

    public Integer getId() {
        return id;
    }

    public Integer getStart_15_00() {
        return start_15_00;
    }

    public Integer getStart_16_30() {
        return start_16_30;
    }

    public Integer getStart_18_00() {
        return start_18_00;
    }

    public Integer getStart_19_30() {
        return start_19_30;
    }

    public Integer getStart_21_00() {
        return start_21_00;
    }

    public Integer getStart_22_30() {
        return start_22_30;
    }
}
