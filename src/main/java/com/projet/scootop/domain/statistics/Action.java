package com.projet.scootop.domain.statistics;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.domain.configuration.ActionType;
import com.projet.scootop.domain.tools.Match;
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
    @JsonIgnoreProperties({"statisticalSheetsTeamA","statisticalSheetsTeamB"})
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
