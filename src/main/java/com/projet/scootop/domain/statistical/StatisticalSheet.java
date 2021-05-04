package com.projet.scootop.domain.statistical;

import javax.persistence.*;

import com.projet.scootop.domain.domainconfiguration.MatchSheet;
import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.services.Event;
import com.projet.scootop.domain.statistical.physical.PlayerHead;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

//Feuille de stats pour un joueur/ pour une team/ pour un event
@Entity
//TODO: Renommer PlayerStatsSheet
@Table(name = "statistical_sheet")
public class StatisticalSheet {
	
	//global
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @OneToOne
    @Getter @Setter
    private MatchSheet matchSheet;

    @OneToOne
    @Getter @Setter
    private Event event;

    @Getter @Setter
    private int nbBallplayed;
    
    @Getter @Setter
    private int nbBalllost;
    
    @Getter @Setter
    private int nbBallSuccess;
  
    @OneToMany
    @Getter @Setter
    private List<Shoot> Shoots;

    @OneToMany
    @Getter @Setter
    private List<PlayerHead> Heads;

    @OneToMany
    @Getter @Setter
    private List<Pass> passes;

    @OneToMany
    @Getter @Setter
    private List<Action> actions;

    @OneToMany
    @Getter @Setter
    private List<Goal> goals;
    
    @ManyToOne
    @Getter @Setter
    private Player player;
    
    @ManyToOne
    @Getter @Setter
    private Team team;

    @Getter @Setter
    private float distancekm;


    public StatisticalSheet(MatchSheet matchSheet, Player player, Event events, int ballplayed,int balllost,int ballSuccess, List<Shoot> shoots, List<PlayerHead> heads, List<Pass> assists, List<Action> skills, List<Goal> goals, float distancekm) {
        this.matchSheet = matchSheet;
        this.player = player;
        this.event = events;
        this.nbBallplayed = ballplayed;
        this.nbBalllost = balllost;
        this.nbBallSuccess = ballSuccess;
        this.Shoots = shoots;
        this.Heads = heads;
        this.passes = assists;
        this.actions = skills;
        this.goals = goals;
        this.distancekm = distancekm;
    }

    public StatisticalSheet() {

    }
}
