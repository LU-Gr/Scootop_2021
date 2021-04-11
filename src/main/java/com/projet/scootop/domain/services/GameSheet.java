package com.projet.scootop.domain.services;

import javax.persistence.*;

import com.projet.scootop.domain.domainconfiguration.Stade;
import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.inprogress.StatisticalSheet;
import com.projet.scootop.domain.user.User;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

//TODO Supprimer?
@Entity
@Table(name = "GameSheet")

public class GameSheet {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @OneToOne
    @Getter @Setter
    private User user;
    
    @ManyToMany
    @Getter @Setter
    private List<Team> teams;
    
    @ManyToMany
    @Getter @Setter
    private List<StatisticalSheet> stactisticalSheets;
    
    @OneToOne
    @Getter @Setter
    private Stade stade;
    
    @OneToOne
    @Getter @Setter
    private Events events;

    @Getter @Setter
    private Date date;


    public GameSheet() {

    }
    public GameSheet(User user, List<Team> teams, List<StatisticalSheet> stactisticalSheets, Stade stade, Events events, Date date) {
        this.user = user;
        this.teams = teams;
        this.stactisticalSheets = stactisticalSheets;
        this.stade = stade;
        this.events = events;
        this.date = date;
    }

}
