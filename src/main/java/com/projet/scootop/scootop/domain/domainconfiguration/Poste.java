package com.projet.scootop.scootop.domain.domainconfiguration;

import javax.persistence.*;

import com.projet.scootop.scootop.domain.domainuser.Player;

import java.util.List;


@Entity
@Table(name = "Poste")
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    
    @ManyToMany
    public List<Player> players;

    public Poste() {
    }

    public Poste(String name, List<Player> player) {
        super();
        this.name = name;
        this.players = player;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
