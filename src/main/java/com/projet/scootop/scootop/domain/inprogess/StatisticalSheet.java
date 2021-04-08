package com.projet.scootop.scootop.domain.inprogess;

import javax.persistence.*;

import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.services.Events;
import com.projet.scootop.scootop.domain.stastistical.Pass;
import com.projet.scootop.scootop.domain.stastistical.Goal;
import com.projet.scootop.scootop.domain.stastistical.Shoot;
import com.projet.scootop.scootop.domain.stastistical.Action;
import com.projet.scootop.scootop.domain.stastistical.physical.PlayerHead;

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
    public Long id;

    @OneToOne
    @Getter @Setter
    public MatchSheet matchSheet;

    @OneToOne
    @Getter @Setter
    public Events events;

    @Getter @Setter
    public int ShootIn;
    
    @Getter @Setter
    public int ShootOut;

    @Getter @Setter
    public int ballplayed;
    
    @Getter @Setter
    public int balllost;
    
    @Getter @Setter
    public int ballSuccess;

    @OneToMany
    @Getter @Setter
    public List<Shoot> Shoots;

    @OneToMany
    @Getter @Setter
    public List<PlayerHead> Heads;

    @OneToMany
    @Getter @Setter
    public List<Pass> passes;

    @OneToMany
    @Getter @Setter
    public List<Action> skills;

    @OneToMany
    @Getter @Setter
    public List<Goal> goals;
    
    // équipe
    @OneToMany
    @Getter @Setter
    public List<Player> players;

    // joueur
    @Getter @Setter
    public float distancekm;


    public StatisticalSheet(MatchSheet matchSheet, List<Player> players, Events events, int shootIn, int shootOut, int ballplayed,int balllost,int ballSuccess, List<Shoot> shoots, List<PlayerHead> heads, List<Pass> assists, List<Action> skills, List<Goal> goals, float distancekm) {
        this.matchSheet = matchSheet;
        this.players = players;
        this.events = events;
        this.ShootIn = shootIn;
        this.ShootOut = shootOut;
        this.ballplayed = ballplayed;
        this.balllost = balllost;
        this.ballSuccess = ballSuccess;
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
