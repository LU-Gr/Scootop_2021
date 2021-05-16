package com.projet.scootop.domain.statistics;

import javax.persistence.*;

import com.projet.scootop.domain.configuration.ActionType;
import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.domain.tools.StatisticalSheet;
import com.projet.scootop.domain.user.domain.Player;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Action : Exemple : Skill: Controle
@ToString
@Entity
@Table(name = "Action")
public class Action {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private int minute;

    @Getter @Setter
    private Boolean isDefensive;
    
    @Getter @Setter
    private Boolean isSuccessful;
    
    // ex : tacle
    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private ActionType actionType;
    
    @ManyToOne
    @Getter @Setter
    private StatisticalSheet statisticalSheet;

    @ManyToOne
    @Getter @Setter
    private Match match;

    @ManyToOne
    @Getter @Setter
    private Player player;

    public Action(Long id, Match matchSheet, Player player, Boolean isDefensive, Boolean succesSkill, Boolean isLong) {
        super();
        this.id = id;
        this.match = matchSheet;
        this.player = player;
        this.isDefensive = isDefensive;
        this.isSuccessful = succesSkill;
    }

    public Action() {
    }
}
