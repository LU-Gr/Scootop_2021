package com.projet.scootop.scootop.domain.stastistical;

import javax.persistence.*;

import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.inprogess.MatchSheet;
import com.projet.scootop.scootop.domain.stastistical.physical.TypeTouch;


@Entity
@Table(name = "SHOOT")
public class Shoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @ManyToOne
    public MatchSheet matchSheet;
    @OneToOne
    public TypeTouch typeTouch;
    @OneToOne
    public Player player;
    public int time;
    public Boolean isFreeKick;
    public Boolean isPenaltyBox;
    public Boolean isGoal;
    public Boolean isLongShoot;
    @OneToOne
    public Pass passer;

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
