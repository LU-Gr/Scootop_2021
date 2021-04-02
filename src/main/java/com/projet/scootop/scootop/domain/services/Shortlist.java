package com.projet.scootop.scootop.domain.services;

import com.projet.scootop.scootop.ApiApplication;
import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.domainuser.Scoot;
import com.projet.scootop.scootop.user.User;
import org.springframework.boot.SpringApplication;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Shortlist")

public class Shortlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @OneToOne
    public User user;

    @OneToMany
    public List <Player> Players;
    @OneToMany
    public List <Scoot> Scoots;
    @OneToMany
    public List <Team> Teams;

    public int rank;

    public Shortlist() {

    }

    public Shortlist(User user, List<Player> players, List<Scoot> scoots, List<Team> teams, int rank) {
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Player> getPlayers() {
        return Players;
    }

    public void setPlayers(List<Player> players) {
        Players = players;
    }

    public List<Scoot> getScoots() {
        return Scoots;
    }

    public void setScoots(List<Scoot> scoots) {
        Scoots = scoots;
    }

    public List<Team> getTeams() {
        return Teams;
    }

    public void setTeams(List<Team> teams) {
        Teams = teams;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

}

