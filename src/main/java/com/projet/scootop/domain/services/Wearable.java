package com.projet.scootop.domain.services;

import javax.persistence.*;

import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.inprogress.MatchSheet;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Wearable")

public class Wearable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Player player;

    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Team team;

    @ManyToOne
    @JoinColumn(name = "Game_id")
    @Getter @Setter
    private MatchSheet matchSheet;
    
    @Getter @Setter
    private Integer distanceRun;
    
    @Getter @Setter
    private Integer distancePlay;
    
    @Getter @Setter
    private Integer vMax;
    
    @Getter @Setter
    private Integer vMaxWithBall;
    
    @Getter @Setter
    private Integer ballPlay;
    
    @Getter @Setter
    private Integer looseBall;
    
    @Getter @Setter
    private Integer ballRecovered;
    
    @Getter @Setter
    private Integer tackle;
    
    @Getter @Setter
    private Integer foulSuffered;
    
    @Getter @Setter
    private Integer failPass;
    
    @Getter @Setter
    private Integer assist;
    
    @Getter @Setter
    private Integer shortPass;
    
    @Getter @Setter
    private Integer head;
    
    @Getter @Setter
    private Integer headOffensive;
    
    @Getter @Setter
    private Integer headDefensive;
    
    @Getter @Setter
    private Integer shots;
    
    @Getter @Setter
    private Integer shotOnTarget;
    
    @Getter @Setter
    private Integer shotOffTarget;
    
    @Getter @Setter
    private Integer longShot;
    
    @Getter @Setter
    private Integer successSkill;
    
    @Getter @Setter
    private Integer failSkill;

    public Wearable() {

    }

    public Wearable(Player player, Team team, MatchSheet matchSheet, Integer distanceRun, Integer distancePlay, Integer vMax, Integer vMaxWithBall, Integer ballPlay, Integer looseBall, Integer ballRecovered, Integer tackle, Integer foulSuffered, Integer failPass, Integer assist, Integer shortPass, Integer head, Integer headOffensive, Integer headDefensive, Integer shots, Integer shotOnTarget, Integer shotOffTarget, Integer longShot, Integer successSkill, Integer failSkill) {
    }

}
