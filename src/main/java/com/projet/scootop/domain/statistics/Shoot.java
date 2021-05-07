package com.projet.scootop.domain.statistics;

import javax.persistence.*;

import com.projet.scootop.domain.configuration.TouchType;
import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.domain.user.domainuser.Player;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "SHOOT")
public class Shoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @ManyToOne
    @Getter @Setter
    private Match matchSheet;
    
    @OneToOne
    @Getter @Setter
    private TouchType typeTouch;
    
    @OneToOne
    @Getter @Setter
    private Player player;
    
    @Getter @Setter
    private int time;
    
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
    private Pass passer;

    public Shoot(Match matchSheet, TouchType typeTouch, Player player, Boolean inBox, Boolean goal, Boolean aLong,Pass assist) {
        super();
        this.matchSheet = matchSheet;
        this.typeTouch = typeTouch;
        this.player = player;
        this.isPenaltyBox = inBox;
        isGoal = goal;
        isLongShoot = aLong;
        this.passer = assist;
    }

    public Shoot() {
    }
}
