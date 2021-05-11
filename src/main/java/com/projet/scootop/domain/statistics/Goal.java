package com.projet.scootop.domain.statistics;

import javax.persistence.*;

import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.domain.user.domainuser.Player;

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
    
    @Getter @Setter
    private Integer rating;
    
    @OneToOne
    @Getter @Setter
    private Shoot shoot;
    
    @ManyToOne
    @Getter @Setter
    private Match match;
    
    @ManyToOne
    @Getter @Setter
    private Player player;
    

    public Goal(LocalDate date, Shoot shoot, Integer rating) {
        super();
        this.date = date;
        this.shoot = shoot;
        this.rating = rating;
    }

    public Goal() {
    }
}
