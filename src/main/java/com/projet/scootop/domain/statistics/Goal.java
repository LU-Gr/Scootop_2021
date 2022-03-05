package com.projet.scootop.domain.statistics;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.domain.user.domain.Player;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Goal")

public class Goal {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    //A ENLEVER
    @Getter @Setter
    private LocalDate date;
    
    @Getter @Setter
    private Integer rating;
    
    @OneToOne
    @Getter @Setter
    @JsonIgnoreProperties({"match"})
    private Shoot shoot;
    
    @ManyToOne
    @Getter @Setter
    @JsonIgnoreProperties({"statisticalSheetsTeamA","statisticalSheetsTeamB"})
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
