package com.projet.scootop.scootop.domain.services.interaction;

import com.projet.scootop.scootop.domain.domaintools.Saison;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.services.Events;
import com.projet.scootop.scootop.domain.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Invite")

public class Invite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne
    public Saison saison;

    @ManyToOne
    public Events events;
    @ManyToOne
    public User user;
    @ManyToOne
    public Player player;
    public LocalDate createAt;
    public boolean response;


    public Invite(Saison saison, Events events, User user, Player player, LocalDate createAt, boolean response) {
        this.saison = saison;
        this.events = events;
        this.user = user;
        this.player = player;
        this.createAt = createAt;
        this.response = response;
    }

    public Invite() {

    }

    public Saison getSaison() {
        return saison;
    }

    public void setSaison(Saison saison) {
        this.saison = saison;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public Long getId() {
        return id;
    }
}
