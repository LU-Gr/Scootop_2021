package com.projet.scootop.domain.statistical.physical;

import javax.persistence.*;

import com.projet.scootop.domain.domainuser.Player;

import lombok.Getter;
import lombok.Setter;

//TODO Supprimer
@Entity
@Table(name = "PLAYERHEAD")
public class PlayerHead {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @OneToOne
    @Getter @Setter
    private Player player;


    public PlayerHead(Player player) {
        this.player = player;
    }

    public PlayerHead() {
    }
}
