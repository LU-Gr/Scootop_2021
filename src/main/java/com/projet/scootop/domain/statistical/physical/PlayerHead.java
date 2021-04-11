package com.projet.scootop.domain.statistical.physical;

import javax.persistence.*;

import com.projet.scootop.domain.domainuser.Player;
//TODO Supprimer
@Entity
@Table(name = "PLAYERHEAD")
public class PlayerHead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @OneToOne
    public Player player;


    public PlayerHead(Player player) {
        this.player = player;
    }

    public PlayerHead() {
    }
}