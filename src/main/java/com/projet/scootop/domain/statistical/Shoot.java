package com.projet.scootop.domain.statistical;

import javax.persistence.*;

import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.inprogress.MatchSheet;
import com.projet.scootop.domain.statistical.physical.TypeTouch;

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
    private MatchSheet matchSheet;
    
    @OneToOne
    @Getter @Setter
    private TypeTouch typeTouch;
    
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
    
    @OneToOne
    @Getter @Setter
    private Pass passer;

    public Shoot(MatchSheet matchSheet, TypeTouch typeTouch, Player player, Boolean inBox, Boolean goal, Boolean aLong,Pass assist) {
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
