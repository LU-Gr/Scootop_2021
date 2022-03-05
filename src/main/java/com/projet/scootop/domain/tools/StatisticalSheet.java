package com.projet.scootop.domain.tools;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.domain.services.Event;
import com.projet.scootop.domain.statistics.Action;
import com.projet.scootop.domain.statistics.Goal;
import com.projet.scootop.domain.statistics.Pass;
import com.projet.scootop.domain.statistics.Shoot;
import com.projet.scootop.domain.user.domain.Player;

import lombok.Getter;
import lombok.Setter;

//Feuille de stats pour un joueur
@Entity
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
    @JsonIgnoreProperties({"statisticalSheetsTeamA","statisticalSheetsTeamB","event"})
    private Match match;

    @OneToOne
    @Getter @Setter
    private Event event;

    
    @Getter @Setter
    @ManyToOne(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"statisticalSheets","teams"})
    private Player player;

    //Pour quelle team le joueur a joué
    @ManyToOne
    @Getter @Setter
    @JsonIgnoreProperties("players")
    private Team team;
  
    @OneToMany
    @JoinColumn(name = "statistical_sheet_id", referencedColumnName = "id")
    @Getter @Setter
    @JsonIgnoreProperties({"match", "player"})
    private List<Shoot> shoots;

    @OneToMany
    @JoinColumn(name = "statistical_sheet_id", referencedColumnName = "id")
    @Getter @Setter
    @JsonIgnoreProperties({"match", "player"})
    private List<Pass> passes;

    @OneToMany
    @JoinColumn(name = "statistical_sheet_id", referencedColumnName = "id")
    @Getter @Setter
    @JsonIgnoreProperties({"match", "player"})
    private List<Action> actions;

    @OneToMany
    @JoinColumn(name = "statistical_sheet_id", referencedColumnName = "id")
    @Getter @Setter
    @JsonIgnoreProperties({"match", "player"})
    private List<Goal> goals;
    

    public StatisticalSheet(Match matchSheet, Player player, Event event) {
        this.match = matchSheet;
        this.player = player;
        this.event = event;
        this.shoots = new ArrayList<>();
        this.passes = new ArrayList<>();
        this.actions = new ArrayList<>();
        this.goals = new ArrayList<>();
    }

    public StatisticalSheet() {
    	this.shoots = new ArrayList<>();
        this.passes = new ArrayList<>();
        this.actions = new ArrayList<>();
        this.goals = new ArrayList<>();
    }
}
