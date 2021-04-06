package com.projet.scootop.scootop.domain.stastistical;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Goal")

public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public LocalDate date;
    @OneToOne
    public Shoot shoot;
    //TODO: Event ??
    public String tag;
    //TODO: Delete
    public Integer distance;
    public Integer rating;



    public Goal(LocalDate date, Shoot shoot, String tag, Integer distance, Integer rating) {
        super();
        this.date = date;
        this.shoot = shoot;
        this.tag = tag;
        this.distance = distance;
        this.rating = rating;
    }

    public Goal() {
    }
}
