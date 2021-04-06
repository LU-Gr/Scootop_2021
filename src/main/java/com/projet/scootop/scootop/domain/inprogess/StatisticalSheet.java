package com.projet.scootop.scootop.domain.inprogess;

import javax.persistence.*;

import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.services.Events;
import com.projet.scootop.scootop.domain.stastistical.Pass;
import com.projet.scootop.scootop.domain.stastistical.Goal;
import com.projet.scootop.scootop.domain.stastistical.Shoot;
import com.projet.scootop.scootop.domain.stastistical.Action;
import com.projet.scootop.scootop.domain.stastistical.physical.PlayerHead;

import java.util.List;

//Feuille de stats pour un joueur/ pour une team/ pour un event
@Entity
//TODO: Renommer PlayerStatsSheet
@Table(name = "STATISTICALSHEET")

public class StatisticalSheet {
	
	//global
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne
    public MatchSheet matchSheet;

    @OneToOne
    public Events events;

    public int ShootIn;
    public int ShootOut;

    public int ballplayed;
    public int balllost;
    public int ballSuccess;

    @OneToMany
    public List<Shoot> Shoots;

    @OneToMany
    public List<PlayerHead> Heads;

    @OneToMany
    public List<Pass> assists;

    @OneToMany
    public List<Action> skills;

    @OneToMany
    public List<Goal> goals;
    
    // équipe
    @OneToMany
    public Player players;

    // joueur
    public float distancekm;


    public StatisticalSheet(MatchSheet matchSheet, List<Player> players, Events events, int shootIn, int shootOut, int ballplayed,int balllost,int ballSuccess, List<Shoot> shoots, List<PlayerHead> heads, List<Pass> assists, List<Action> skills, List<Goal> goals, float distancekm) {
        this.matchSheet = matchSheet;
        this.players = players;
        this.events = events;
        this.ShootIn = shootIn;
        this.ShootOut = shootOut;
        this.ballplayed = ballplayed;
        this.balllost = balllost;
        this.ballSuccess = ballSuccess;
        this.Shoots = shoots;
        this.Heads = heads;
        this.assists = assists;
        this.skills = skills;
        this.goals = goals;
        this.players = players;
        this.distancekm = distancekm;
    }

    public StatisticalSheet() {

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

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public int getShootIn() {
        return ShootIn;
    }

    public void setShootIn(int shootIn) {
        ShootIn = shootIn;
    }

    public int getShootOut() {
        return ShootOut;
    }

    public void setShootOut(int shootOut) {
        ShootOut = shootOut;
    }

    public int getBallplayed() {
        return ballplayed;
    }

    public void setBallplayed(int ballplayed) {
        this.ballplayed = ballplayed;
    }

    public List<Shoot> getShoots() {
        return Shoots;
    }

    public void setShoots(List<Shoot> shoots) {
        Shoots = shoots;
    }

    public List<PlayerHead> getHeads() {
        return Heads;
    }

    public void setHeads(List<PlayerHead> heads) {
        Heads = heads;
    }

    public List<Pass> getAssists() {
        return assists;
    }

    public void setAssists(List<Pass> assists) {
        this.assists = assists;
    }

    public List<Action> getSkills() {
        return skills;
    }

    public void setSkills(List<Action> skills) {
        this.skills = skills;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public float getDistancekm() {
        return distancekm;
    }

    public void setDistancekm(float distancekm) {
        this.distancekm = distancekm;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getBalllost() {
        return balllost;
    }

    public void setBalllost(int balllost) {
        this.balllost = balllost;
    }

    public int getBallSuccess() {
        return ballSuccess;
    }

    public void setBallSuccess(int ballSuccess) {
        this.ballSuccess = ballSuccess;
    }
}
