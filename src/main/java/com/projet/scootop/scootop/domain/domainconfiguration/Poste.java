package com.projet.scootop.scootop.domain.domainconfiguration;

import javax.persistence.*;

import com.projet.scootop.scootop.domain.domainuser.Player;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "Poste")
public class Poste {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String name;
    
    @ManyToMany
    @Getter @Setter
    private List<Player> players;

    public Poste() {
    }

    public Poste(String name, List<Player> player) {
        super();
        this.name = name;
        this.players = player;
    }
}
