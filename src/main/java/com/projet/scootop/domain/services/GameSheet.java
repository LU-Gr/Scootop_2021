package com.projet.scootop.domain.services;

import javax.persistence.*;

import com.projet.scootop.domain.domainconfiguration.Stade;
import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.inprogress.StatisticalSheet;
import com.projet.scootop.domain.user.User;

import java.util.Date;
import java.util.List;

//TODO Supprimer?
@Entity
@Table(name = "GameSheet")

public class GameSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @OneToOne
    public User user;
    @ManyToMany
    public List<Team> teams;
    @ManyToMany
    public List<StatisticalSheet> stactisticalSheets;
    @OneToOne
    public Stade stade;
    @OneToOne
    public Events events;

    public Date date;


    public GameSheet() {

    }
    public GameSheet(User user, List<Team> teams, List<StatisticalSheet> stactisticalSheets, Stade stade, Events events, Date date) {
        this.user = user;
        this.teams = teams;
        this.stactisticalSheets = stactisticalSheets;
        this.stade = stade;
        this.events = events;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<StatisticalSheet> getStactisticalSheets() {
        return stactisticalSheets;
    }

    public void setStactisticalSheets(List<StatisticalSheet> stactisticalSheets) {
        this.stactisticalSheets = stactisticalSheets;
    }

    public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
