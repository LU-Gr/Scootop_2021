package com.projet.scootop.domain.statistics;

import javax.persistence.*;

import com.projet.scootop.domain.configuration.ActionType;
import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.domain.user.domainuser.Player;

import lombok.Getter;
import lombok.Setter;

// Action : Exemple : Skill: Controle
@Entity
@Table(name = "Action")

public class Action {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    // ex : tacle
    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private ActionType actionType;

    @OneToOne
    @Getter @Setter
    private Match matchSheet;

    @OneToOne
    @Getter @Setter
    private Player player;

    @Getter @Setter
    private Boolean isDefensive;
    
    @Getter @Setter
    private Boolean isSuccessful;

    public Action(Long id, Match matchSheet, Player player, Boolean isDefensive, Boolean succesSkill, Boolean isLong) {
        super();
        this.id = id;
        this.matchSheet = matchSheet;
        this.player = player;
        this.isDefensive = isDefensive;
        this.isSuccessful = succesSkill;
    }

    public Action() {
    }
}
