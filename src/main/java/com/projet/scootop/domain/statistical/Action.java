package com.projet.scootop.domain.statistical;

import javax.persistence.*;

import com.projet.scootop.domain.domaintools.Skill;
import com.projet.scootop.domain.domaintools.SkillType;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.inprogress.MatchSheet;

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
    
    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Skill skill;
    
    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private SkillType skillType;

    @OneToOne
    @Getter @Setter
    private MatchSheet matchSheet;

    @OneToOne
    @Getter @Setter
    private Player player;

    @Getter @Setter
    private Boolean isDefensive;
    
    @Getter @Setter
    private Boolean isSuccessful;

    public Action(Long id, MatchSheet matchSheet, Player player, Boolean isDefensive, Boolean succesSkill, Boolean isLong) {
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
