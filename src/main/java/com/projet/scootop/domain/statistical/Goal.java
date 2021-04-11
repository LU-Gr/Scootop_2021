package com.projet.scootop.domain.statistical;

import javax.persistence.*;

import lombok.Setter;

import lombok.Getter;

import java.time.LocalDate;

@Entity
@Table(name = "Goal")

public class Goal {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private LocalDate date;
    
    @OneToOne
    @Getter @Setter
    private Shoot shoot;
    
    //TODO: Event ??
    @Getter @Setter
    private String tag;
    
    //TODO: Delete
    @Getter @Setter
    private Integer distance;
    
    @Getter @Setter
    private Integer rating;

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
