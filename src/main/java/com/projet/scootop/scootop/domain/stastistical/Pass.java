package com.projet.scootop.scootop.domain.stastistical;

import javax.persistence.*;

import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.inprogess.MatchSheet;
import com.projet.scootop.scootop.domain.stastistical.physical.TypeTouch;

import java.time.LocalDate;

@Entity
@Table(name = "Pass")

public class Pass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    public MatchSheet matchSheet;
    public LocalDate date;

    @OneToOne
    public Player player;
    @OneToOne
    public TypeTouch typeTouch;

    public Boolean decisive;
    public Boolean isSuccess;
    public Boolean longPass;


    public Pass() {
    }

    public Pass(MatchSheet matchSheet, Player player,LocalDate date, TypeTouch typeTouch, Boolean decisive, Boolean isSuccess, Boolean longPass) {
        super();
        this.matchSheet = matchSheet;
        this.date = date;
        this.player = player;
        this.typeTouch = typeTouch;
        this.decisive = decisive;
        this.isSuccess = isSuccess;
        this.longPass = longPass;
    }

    public Long getId() {
        return id;
    }

    public MatchSheet getMatchSheet() {
        return matchSheet;
    }

    public void setMatchSheet(MatchSheet matchSheet) {
        this.matchSheet = matchSheet;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public TypeTouch getTypeTouch() {
        return typeTouch;
    }

    public void setTypeTouch(TypeTouch typeTouch) {
        this.typeTouch = typeTouch;
    }

    public Boolean getDecisive() {
        return decisive;
    }

    public void setDecisive(Boolean decisive) {
        this.decisive = decisive;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Boolean getLongPass() {
        return longPass;
    }

    public void setLongPass(Boolean longPass) {
        this.longPass = longPass;
    }
}
