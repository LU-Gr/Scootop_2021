package com.projet.scootop.domain.tools;

import javax.persistence.*;

import com.projet.scootop.domain.services.Event;
import com.projet.scootop.domain.statistics.Action;
import com.projet.scootop.domain.statistics.Goal;
import com.projet.scootop.domain.statistics.Pass;
import com.projet.scootop.domain.statistics.Shoot;
import com.projet.scootop.domain.user.domainuser.Player;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

//Feuille de stats pour un joueur
@ToString
@Entity
@Table(name = "statisticalSheet")
public class StatisticalSheet {
	
	//global
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private int nbBallplayed;
    
    @Getter @Setter
    private int nbBalllost;
    
    @Getter @Setter
    private int nbBallSuccess;
    
    @Getter @Setter
    private float distancekm;

    @OneToOne
    @Getter @Setter
    private Match match;

    @OneToOne
    @Getter @Setter
    private Event event;

    @ManyToOne
    @Getter @Setter
    private Player player;
    
    @ManyToOne
    @Getter @Setter
    private Team team;
  
    @OneToMany
    @JoinColumn(name = "statistical_sheet_id", referencedColumnName = "id")
    @Getter @Setter
    private List<Shoot> Shoots;

    @OneToMany
    @JoinColumn(name = "statistical_sheet_id", referencedColumnName = "id")
    @Getter @Setter
    private List<Pass> passes;

    @OneToMany
    @JoinColumn(name = "statistical_sheet_id", referencedColumnName = "id")
    @Getter @Setter
    private List<Action> actions;

    @OneToMany
    @JoinColumn(name = "statistical_sheet_id", referencedColumnName = "id")
    @Getter @Setter
    private List<Goal> goals;
    

    public StatisticalSheet(Match matchSheet, Player player, Event events, int ballplayed,int balllost,int ballSuccess, List<Shoot> shoots, List<Pass> assists, List<Action> skills, List<Goal> goals, float distancekm) {
        this.match = matchSheet;
        this.player = player;
        this.event = events;
        this.nbBallplayed = ballplayed;
        this.nbBalllost = balllost;
        this.nbBallSuccess = ballSuccess;
        this.Shoots = shoots;
        this.passes = assists;
        this.actions = skills;
        this.goals = goals;
        this.distancekm = distancekm;
    }

    public StatisticalSheet() {

    }
}
