package com.projet.scootop.domain.statistics;

import javax.persistence.*;

import com.projet.scootop.domain.configuration.TouchType;
import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.domain.tools.StatisticalSheet;
import com.projet.scootop.domain.user.domain.Player;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
public class Shoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private int minute;
    
    @Getter @Setter
    private Boolean isFreeKick;
    
    @Getter @Setter
    private Boolean isPenaltyBox;
    
    @Getter @Setter
    private Boolean isGoal;
    
    @Getter @Setter
    private Boolean isLongShoot;
    
    @Getter @Setter
    private Boolean isInBox;
    
    @OneToOne
    @Getter @Setter
    private Pass pass;
    
    @ManyToOne
    @Getter @Setter
    private StatisticalSheet statisticalSheet;
    
    @ManyToOne
    @Getter @Setter
    private Match match;
    
    @ManyToOne
    @Getter @Setter
    private TouchType touchType;
    
    @ManyToOne
    @Getter @Setter
    private Player player;


    public Shoot(Match matchSheet, TouchType typeTouch, Player player, Boolean inBox, Boolean goal, Boolean aLong,Pass pass) {
        super();
        this.match = matchSheet;
        this.touchType = typeTouch;
        this.player = player;
        this.isPenaltyBox = inBox;
        this.isGoal = goal;
        this.isLongShoot = aLong;
        this.pass = pass;
    }

    public Shoot() {
    }
}
