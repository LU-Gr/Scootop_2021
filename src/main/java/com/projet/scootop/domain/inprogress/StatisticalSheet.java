package com.projet.scootop.domain.inprogress;

import javax.persistence.*;

import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.services.Events;
import com.projet.scootop.domain.statistical.Action;
import com.projet.scootop.domain.statistical.Goal;
import com.projet.scootop.domain.statistical.Pass;
import com.projet.scootop.domain.statistical.Shoot;
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
    private Events events;

    @Getter @Setter
    private int nbShootIn;
    
    @Getter @Setter
    private int nbShootOut;

    @Getter @Setter
    private int nbBallplayed;
    
    @Getter @Setter
    private int nbBalllost;
    
    @Getter @Setter
    private int nbBallSuccess;
    
    @Getter @Setter
    private int nbDefensiveSkills;
    
    @Getter @Setter
    private int nbOffensiveSkills;

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
    private List<Action> skills;

    @OneToMany
    @Getter @Setter
    private List<Goal> goals;
    
    // équipe
    @OneToMany
    @Getter @Setter
    private List<Player> players;

    // joueur
    @Getter @Setter
    private float distancekm;


    public StatisticalSheet(MatchSheet matchSheet, List<Player> players, Events events, int shootIn, int shootOut, int ballplayed,int balllost,int ballSuccess, List<Shoot> shoots, List<PlayerHead> heads, List<Pass> assists, List<Action> skills, List<Goal> goals, float distancekm) {
        this.matchSheet = matchSheet;
        this.players = players;
        this.events = events;
        this.nbShootIn = shootIn;
        this.nbShootOut = shootOut;
        this.nbBallplayed = ballplayed;
        this.nbBalllost = balllost;
        this.nbBallSuccess = ballSuccess;
        this.Shoots = shoots;
        this.Heads = heads;
        this.passes = assists;
        this.skills = skills;
        this.goals = goals;
        this.players = players;
        this.distancekm = distancekm;
    }

    public StatisticalSheet() {

    }
}
