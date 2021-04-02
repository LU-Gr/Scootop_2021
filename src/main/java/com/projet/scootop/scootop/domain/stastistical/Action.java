package com.projet.scootop.scootop.domain.stastistical;

import javax.persistence.*;

import com.projet.scootop.scootop.domain.domaintools.SkillType;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.inprogess.MatchSheet;

// Action : Exemple : Skill: Controle
@Entity
@Table(name = "Skill")

public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    
    // public Skill
    
    public SkillType skillType;

    @OneToOne
    public MatchSheet matchSheet;

    @OneToOne
    public Player player;

    
    public Boolean isDefensive;
    public Boolean isSuccessful;

    public Action(Integer id, MatchSheet matchSheet, Player player, Boolean isDefensive, Boolean succesSkill, Boolean isLong) {
        super();
        this.id = id;
        this.matchSheet = matchSheet;
        this.player = player;
        this.isDefensive = isDefensive;
        this.isSuccessful = succesSkill;
    }

    public Action() {
    }

    public Integer getId() {
        return id;
    }

    public MatchSheet getMatchSheet() {
        return matchSheet;
    }

    public void setMatchSheet(MatchSheet matchSheet) {
        this.matchSheet = matchSheet;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Boolean getDefensive() {
        return isDefensive;
    }

    public void setDefensive(Boolean defensive) {
        isDefensive = defensive;
    }

    public Boolean getSuccessSkill() {
        return isSuccessful;
    }

    public void setSuccessSkill(Boolean successSkill) {
        this.isSuccessful = successSkill;
    }
}
